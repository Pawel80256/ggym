package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreateTrainingWeekDto;
import com.ggymserver.entity.TrainingWeek;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TrainingDayMapper.class}
)
public interface TrainingWeekMapper {
    TrainingWeek toEntity(CreateTrainingWeekDto createTrainingWeekDto);

    @AfterMapping
    default void linkDays (@MappingTarget TrainingWeek trainingWeek, CreateTrainingWeekDto dto) {
        if(dto.trainingDays() != null && !dto.trainingDays().isEmpty()) {
            trainingWeek.getTrainingDays().forEach(day -> day.setTrainingWeek(trainingWeek));
        }
    }
}