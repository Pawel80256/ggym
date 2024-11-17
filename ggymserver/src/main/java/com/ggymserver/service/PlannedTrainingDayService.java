package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedTrainingDayDto;
import com.ggymserver.entity.PlannedTrainingDay;
import com.ggymserver.mapper.PlannedTrainingDayMapper;
import com.ggymserver.repository.PlannedTrainingDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedTrainingDayService {
    private final PlannedTrainingDayRepository plannedTrainingDayRepository;
    private final PlannedTrainingDayMapper plannedTrainingDayMapper;

    public void create (CreatePlannedTrainingDayDto dto) {
        PlannedTrainingDay ptd = plannedTrainingDayMapper.toEntity(dto);
        plannedTrainingDayRepository.save(ptd);
    }

}
