package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.entity.PlannedExercise;
import com.ggymserver.mapper.PlannedExerciseMapper;
import com.ggymserver.repository.PlannedExerciseRepository;
import com.ggymserver.repository.PlannedTrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedExerciseService {
    private final PlannedExerciseRepository plannedExerciseRepository;
    private final PlannedTrainingRepository plannedTrainingRepository;
    private final PlannedExerciseMapper plannedExerciseMapper;

    public void create (Long plannedTrainingId, CreatePlannedExerciseDto dto) {
        var plannedTraining = plannedTrainingRepository.findById(plannedTrainingId)
                .orElseThrow(() -> new IllegalArgumentException("Planned training not found"));

        PlannedExercise plannedExercise = plannedExerciseMapper.toEntity(dto);
        plannedExercise.setPlannedTraining(plannedTraining);

        plannedExerciseRepository.save(plannedExercise);
    }
}
