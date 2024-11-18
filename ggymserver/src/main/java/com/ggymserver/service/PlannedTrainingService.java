package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.entity.PlannedExercise;
import com.ggymserver.mapper.PlannedExerciseMapper;
import com.ggymserver.mapper.PlannedTrainingMapper;
import com.ggymserver.repository.PlannedTrainingRepository;
import com.ggymserver.repository.TrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedTrainingService {
    private final PlannedTrainingRepository plannedTrainingRepository;
    private final TrainingDayRepository trainingDayRepository;
    private final PlannedTrainingMapper plannedTrainingMapper;
    private final PlannedExerciseMapper plannedExerciseMapper;

    public void addPlannedExercise (Long plannedTrainingId, CreatePlannedExerciseDto plannedExerciseDto) {
        var plannedTraining = plannedTrainingRepository.findById(plannedTrainingId)
                .orElseThrow(() -> new IllegalArgumentException("Planned training not found"));
        PlannedExercise plannedExercise = plannedExerciseMapper.toEntity(plannedExerciseDto);
        plannedTraining.addPlannedExercise(plannedExercise);
        plannedTrainingRepository.save(plannedTraining);
    }
}
