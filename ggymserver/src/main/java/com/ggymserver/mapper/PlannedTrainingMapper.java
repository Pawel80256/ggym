package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreatePlannedTrainingDto;
import com.ggymserver.entity.Exercise;
import com.ggymserver.entity.PlannedTraining;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PlannedExerciseMapper.class}
)
public interface PlannedTrainingMapper {
    PlannedTraining toEntity(CreatePlannedTrainingDto createPlannedTrainingDto);

    @AfterMapping
    default void linkExercises (@MappingTarget PlannedTraining plannedTraining, CreatePlannedTrainingDto dto) {
        if(dto.plannedExercises() != null && !dto.plannedExercises().isEmpty()) {
            plannedTraining.getPlannedExercises().forEach(exercise -> exercise.setPlannedTraining(plannedTraining));
        }
    }
}