package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.entity.PlannedExercise;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlannedExerciseMapper {
    @Mapping(source = "exerciseId", target = "exercise.id")
    PlannedExercise toEntity(CreatePlannedExerciseDto createPlannedExerciseDto);
}