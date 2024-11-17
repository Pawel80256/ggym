package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreatePlannedTrainingWeekDto;
import com.ggymserver.entity.PlannedTrainingWeek;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PlannedTrainingDayMapper.class}
)
public interface PlannedTrainingWeekMapper {
    PlannedTrainingWeek toEntity(CreatePlannedTrainingWeekDto createPlannedTrainingWeekDto);

    @AfterMapping
    default void linkDays (@MappingTarget PlannedTrainingWeek plannedTrainingWeek, CreatePlannedTrainingWeekDto dto) {
        if(dto.plannedTrainingDays() != null && !dto.plannedTrainingDays().isEmpty()) {
            plannedTrainingWeek.getPlannedTrainingDays().forEach(day -> day.setPlannedTrainingWeek(plannedTrainingWeek));
        }
    }
}