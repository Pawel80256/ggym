package com.ggymserver.utility;

import jakarta.persistence.criteria.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.ggymserver.utility.LazyRequest.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtil {

    public static <T> LazyResponse<T> getLazyResponse(LazyRequest request, JpaSpecificationExecutor<T> repository, List<FieldPath> fieldPaths) {
        Sort sort = Sort.unsorted();
        if (request.sorting() != null && !request.sorting().isEmpty()) {
            sort = buildSorting(request.sorting());
        }

        Pagination pagination = request.pagination();
        Pageable pageable = PageRequest.of(pagination.pageIndex(), pagination.pageSize(), sort);

        Specification<T> filterSpec = null;
        if (!request.filtering().isEmpty()) {
            filterSpec = buildFiltering(request.filtering(), fieldPaths);
        }

        Page<T> page = repository.findAll(filterSpec, pageable);

        int pageIndex = pagination.pageIndex();

        if (pageIndex >= page.getTotalPages()) {
            pageIndex = Math.max(page.getTotalPages() - 1, 0);
            pageable = PageRequest.of(pageIndex, pagination.pageSize(), sort);
            page = repository.findAll(filterSpec, pageable);
        }

        return new LazyResponse<>(
                page.getContent(),
                pageIndex,
                request.pagination().pageSize(),
                page.getTotalElements()
        );
    }

    private static Sort buildSorting(List<Sorting> sortingList) {
        List<Sort.Order> orders = new ArrayList<>();
        for (Sorting sorting : sortingList) {
            orders.add(new Sort.Order(sorting.direction(), sorting.column()));
        }
        return Sort.by(orders);
    }

    private static <T> Specification<T> buildFiltering(List<Filtering> filters, List<FieldPath> fieldPaths) {
        return filters.stream()
                .map(filter -> switch (filter.filteringType()) {
                    case LIKE -> PaginationUtil.<T>like(filter, fieldPaths);
                    case EQUALS -> PaginationUtil.<T>equals(filter, fieldPaths);
                    case IN -> PaginationUtil.<T>in(filter, fieldPaths);
                    case BETWEEN -> PaginationUtil.<T>between(filter, fieldPaths);
                }).reduce(Specification::and).orElse(null);
    }

    private static <T> Specification<T> like(Filtering filter, List<FieldPath> fieldPaths) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        getPathForColumn(root, filter, fieldPaths).as(String.class),
                        filter.value().get(0) + "%"
                );
    }

    private static <T> Specification<T> equals(Filtering filter, List<FieldPath> fieldPaths) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        getPathForColumn(root, filter, fieldPaths),
                        filter.value().get(0)
                );
    }

    private static <T> Specification<T> in(Filtering filter, List<FieldPath> fieldPaths) {
        return (root, query, criteriaBuilder) -> {
            CriteriaBuilder.In<Object> inClause = criteriaBuilder.in(getPathForColumn(root, filter, fieldPaths));
            filter.value().forEach(inClause::value);
            return inClause;
        };
    }

    private static <T> Specification<T> between(Filtering filter, List<FieldPath> fieldPaths) {
        return (root, query, criteriaBuilder) -> {
            Path<?> path = getPathForColumn(root, filter, fieldPaths);
            Class<?> fieldType = path.getJavaType();

            if (Number.class.isAssignableFrom(fieldType)) {
                if (fieldType == Integer.class) {
                    @SuppressWarnings("unchecked")
                    Path<Integer> intPath = (Path<Integer>) path;
                    List<Number> numbers = parseNumbers(filter.value());
                    return criteriaBuilder.between(intPath, numbers.get(0).intValue(), numbers.get(1).intValue());
                } else if (fieldType == Double.class) {
                    @SuppressWarnings("unchecked")
                    Path<Double> doublePath = (Path<Double>) path;
                    List<Number> numbers = parseNumbers(filter.value());
                    return criteriaBuilder.between(doublePath, numbers.get(0).doubleValue(), numbers.get(1).doubleValue());
                } else {
                    throw new IllegalArgumentException("Unsupported number type: " + fieldType);
                }
            } else if (LocalDateTime.class.isAssignableFrom(fieldType)) {
                @SuppressWarnings("unchecked")
                Path<LocalDateTime> datePath = (Path<LocalDateTime>) path;
                List<LocalDateTime> dateTimes = parseDates(filter.value());
                return criteriaBuilder.between(datePath, dateTimes.get(0), dateTimes.get(1));
            } else {
                throw new IllegalArgumentException("Unsupported field type for between operation: " + fieldType);
            }
        };
    }

    private static List<LocalDateTime> parseDates(List<Object> values) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        return values.stream().limit(2).map(value -> {
                    if (value == null)
                        throw new IllegalArgumentException("Null value detected in date filters");

                    String dateStr = value.toString().trim();
                    if (dateStr.isEmpty())
                        throw new IllegalArgumentException("Empty value detected in date filters");

                    try {
                        return LocalDateTime.parse(value.toString(), formatter);
                    } catch (DateTimeParseException e) {
                        throw new IllegalArgumentException("Date format is invalid: " + value, e);
                    }
                })
                .collect(Collectors.toList());
    }

    private static List<Number> parseNumbers(List<Object> values) {
        return values.stream().limit(2).map(value -> {
                    if (value == null)
                        throw new IllegalArgumentException("Null value detected in number filters");

                    String numStr = value.toString().trim();
                    if (numStr.isEmpty())
                        throw new IllegalArgumentException("Empty value detected in number filters");

                    try {
                        return numStr.contains(".") ? Double.parseDouble(numStr) : Integer.parseInt(numStr);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number format: " + numStr, e);
                    }
                })
                .collect(Collectors.toList());
    }

    private static <T> Path<?> getPathForColumn(Root<T> root, Filtering filter, List<FieldPath> fieldPaths) {
        String column = fieldPaths.stream()
                .filter(e -> e.target().equalsIgnoreCase(filter.column()))
                .map(FieldPath::source).findFirst().orElse(filter.column());
        String[] parts = column.split("\\.");
        From<?, ?> from = root;
        for (int i = 0; i < parts.length - 1; i++) {
            from = from.join(parts[i], JoinType.LEFT);
        }
        return from.get(parts[parts.length - 1]);
    }
}