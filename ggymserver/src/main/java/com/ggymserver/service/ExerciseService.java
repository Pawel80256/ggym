package com.ggymserver.service;

import com.ggymserver.entity.Exercise;
import com.ggymserver.entity.ExerciseDto;
import com.ggymserver.mapper.ExerciseMapper;
import com.ggymserver.repository.ExerciseRepository;
import com.ggymserver.utility.FieldPath;
import com.ggymserver.utility.LazyRequest;
import com.ggymserver.utility.LazyResponse;
import com.ggymserver.utility.PaginationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public LazyResponse<ExerciseDto> getLazy(LazyRequest lazyRequest) {
        List<FieldPath> fieldPaths = Arrays.asList(new FieldPath("exerciseType.name","exerciseTypes"));
        return PaginationUtil.getLazyResponse(lazyRequest, exerciseRepository, fieldPaths).map(exerciseMapper::toDto);
    }
}

