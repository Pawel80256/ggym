//package com.ggymserver.mapper;
//
//import com.ggymserver.dto.PlannedTrainingDto;
//import com.ggymserver.entity.PlannedTraining;
//import org.mapstruct.*;
//
//@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        componentModel = MappingConstants.ComponentModel.SPRING,
//        uses = {PlannedExerciseMapper.class}
//)
//public interface PlannedTrainingMapper {
//    PlannedTraining toEntity(PlannedTrainingDto plannedTrainingDto);
//
//    @AfterMapping
//    default void linkExercises (@MappingTarget PlannedTraining plannedTraining, PlannedTrainingDto dto) {
//        if(dto.plannedExercises() != null && !dto.plannedExercises().isEmpty()) {
//            plannedTraining.getPlannedExercises().forEach(exercise -> exercise.setPlannedTraining(plannedTraining));
//        }
//    }
//}