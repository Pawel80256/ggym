package com.ggymserver.mapper;

import com.ggymserver.entity.Exercise;
import com.ggymserver.entity.ExerciseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ExerciseTypeMapper.class}
)
public interface ExerciseMapper {
    ExerciseDto toDto(Exercise exercise);
}

