package com.ggymserver.service;

import com.ggymserver.dto.request.CreatePlannedTrainingWeekDto;
import com.ggymserver.entity.PlannedTrainingWeek;
import com.ggymserver.mapper.PlannedTrainingWeekMapper;
import com.ggymserver.repository.PlannedTrainingWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannedTrainingWeekService {
    private final PlannedTrainingWeekRepository plannedTrainingWeekRepository;
    private final PlannedTrainingWeekMapper plannedTrainingWeekMapper;

    public void create (CreatePlannedTrainingWeekDto dto) {
        PlannedTrainingWeek plannedTrainingWeek = plannedTrainingWeekMapper.toEntity(dto);
        plannedTrainingWeekRepository.save(plannedTrainingWeek);
    }
}
