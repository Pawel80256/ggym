package com.ggymserver.mapper;

import com.ggymserver.dto.request.TrainingWeekDto;
import com.ggymserver.entity.TrainingWeek;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TrainingDayMapper.class}
)
public interface TrainingWeekMapper {
    TrainingWeek toEntity(TrainingWeekDto trainingWeekDto);

    @AfterMapping
    default void linkDays (@MappingTarget TrainingWeek trainingWeek, TrainingWeekDto dto) {
        if(dto.trainingDays() != null && !dto.trainingDays().isEmpty()) {
            trainingWeek.getTrainingDays().forEach(day -> day.setTrainingWeek(trainingWeek));
        }
    }
}