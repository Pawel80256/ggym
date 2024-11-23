package com.ggymserver.mapper;

import com.ggymserver.dto.ExerciseTypeNameDto;
import com.ggymserver.entity.ExerciseType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ExerciseTypeMapper {
    ExerciseTypeNameDto toNameDto(ExerciseType type);
}
