//package com.ggymserver.mapper;
//
//import com.ggymserver.dto.PlannedExerciseDto;
//import com.ggymserver.entity.PlannedExercise;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
//import org.mapstruct.ReportingPolicy;
//
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
//public interface PlannedExerciseMapper {
//    @Mapping(source = "exerciseId", target = "exercise.id")
//    PlannedExercise toEntity(PlannedExerciseDto plannedExerciseDto);
//}