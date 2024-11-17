package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.entity.PlannedExercise;
import com.ggymserver.mapper.PlannedExerciseMapper;
import com.ggymserver.repository.PlannedExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedExerciseService {
    private final PlannedExerciseRepository plannedExerciseRepository;
    private final PlannedExerciseMapper plannedExerciseMapper;

    public void create (CreatePlannedExerciseDto dto) {
        PlannedExercise plannedExercise = plannedExerciseMapper.toEntity(dto);
        plannedExerciseRepository.save(plannedExercise);
    }
}
