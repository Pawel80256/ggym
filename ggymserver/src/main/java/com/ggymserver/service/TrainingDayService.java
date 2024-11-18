package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedTrainingDto;
import com.ggymserver.entity.PlannedTraining;
import com.ggymserver.mapper.PlannedTrainingMapper;
import com.ggymserver.repository.TrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;
    private final PlannedTrainingMapper plannedTrainingMapper;

    public void addTraining(Long trainingDayId, CreatePlannedTrainingDto plannedTrainingDto) {
        var trainingDay = trainingDayRepository.findById(trainingDayId)
                .orElseThrow(() -> new IllegalArgumentException("Training day not found"));
        PlannedTraining plannedTraining = plannedTrainingMapper.toEntity(plannedTrainingDto);
        trainingDay.addPlannedTraining(plannedTraining);
        trainingDayRepository.save(trainingDay);
    }

}
