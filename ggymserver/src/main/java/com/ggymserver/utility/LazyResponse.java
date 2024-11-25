package com.ggymserver.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LazyResponse<T> {
    private List<T> data;
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalCount;

    public <U> LazyResponse<U> map(Function<? super T, ? extends U> mapper) {
        List<U> mappedRecords = this.data.stream().map(mapper).collect(Collectors.toList());

        return new LazyResponse<>(
                mappedRecords,
                this.pageIndex,
                this.pageSize,
                this.totalCount
        );
    }
}