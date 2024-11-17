package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedTrainingDto;
import com.ggymserver.entity.PlannedTraining;
import com.ggymserver.mapper.PlannedTrainingMapper;
import com.ggymserver.repository.PlannedTrainingRepository;
import com.ggymserver.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedTrainingService {
    private final PlannedTrainingRepository plannedTrainingRepository;
    private final PlannedTrainingMapper plannedTrainingMapper;

    public void create (CreatePlannedTrainingDto dto) {
        PlannedTraining plannedTraining = plannedTrainingMapper.toEntity(dto);
        plannedTrainingRepository.save(plannedTraining);
    }
}
