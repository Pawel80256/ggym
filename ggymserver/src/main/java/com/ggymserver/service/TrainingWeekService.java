package com.ggymserver.service;

import com.ggymserver.dto.request.CreateTrainingDayDto;
import com.ggymserver.entity.TrainingDay;
import com.ggymserver.mapper.TrainingDayMapper;
import com.ggymserver.repository.TrainingWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingWeekService {
    private final TrainingWeekRepository trainingWeekRepository;
    private final TrainingDayMapper trainingDayMapper;

    public void addTrainingDay(Long trainingWeekId, CreateTrainingDayDto dto) {
        var trainingWeek = trainingWeekRepository.findById(trainingWeekId)
                .orElseThrow(() -> new IllegalArgumentException("Planned training week not found"));
        TrainingDay trainingDay = trainingDayMapper.toEntity(dto);
        trainingWeek.addTrainingDay(trainingDay);
        trainingWeekRepository.save(trainingWeek);
    }
}
