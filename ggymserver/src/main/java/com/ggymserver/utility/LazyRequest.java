package com.ggymserver.utility;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.data.domain.Sort;

import java.util.List;

public record LazyRequest(
        Pagination pagination,
        List<Sorting> sorting,
        List<Filtering> filtering
) {
    public record Pagination(
            @NonNull Integer pageIndex,
            @NonNull @Max(100) @Min(1) Integer pageSize
    ) {}

    public record Sorting(
            @NonNull Sort.Direction direction,
            @NonNull String column
    ) {}

    public record Filtering(
            @NonNull String column,
            @NonNull FilteringType filteringType,
            @NonNull List<Object> value
    ) {}

    public enum FilteringType {
        EQUALS, LIKE, IN, BETWEEN, CONTAINS_ALL
    }
}
