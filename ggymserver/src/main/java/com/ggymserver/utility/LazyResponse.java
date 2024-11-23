package com.ggymserver.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LazyResponse<T> {
    private List<T> data;
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalCount;
}