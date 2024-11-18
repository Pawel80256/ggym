package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreateTrainingDayDto;
import com.ggymserver.entity.TrainingDay;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PlannedTrainingMapper.class}
)
public interface TrainingDayMapper {
    TrainingDay toEntity(CreateTrainingDayDto createTrainingDayDto);

    @AfterMapping
    default void linkTrainings (@MappingTarget TrainingDay trainingDay, CreateTrainingDayDto dto) {
        if(dto.plannedTrainings() != null && !dto.plannedTrainings().isEmpty()) {
            trainingDay.getPlannedTrainings().forEach(training -> training.setTrainingDay(trainingDay));
        }
    }
}