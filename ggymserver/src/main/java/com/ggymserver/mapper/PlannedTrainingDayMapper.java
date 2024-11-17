package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreatePlannedTrainingDayDto;
import com.ggymserver.entity.PlannedTrainingDay;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PlannedTrainingMapper.class}
)
public interface PlannedTrainingDayMapper {
    PlannedTrainingDay toEntity(CreatePlannedTrainingDayDto createPlannedTrainingDayDto);

    @AfterMapping
    default void linkTrainings (@MappingTarget PlannedTrainingDay plannedTrainingDay, CreatePlannedTrainingDayDto dto) {
        if(dto.plannedTrainings() != null && !dto.plannedTrainings().isEmpty()) {
            plannedTrainingDay.getPlannedTrainings().forEach(training -> training.setPlannedTrainingDay(plannedTrainingDay));
        }
    }
}