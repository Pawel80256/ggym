//package com.ggymserver.mapper;
//
//import com.ggymserver.dto.TrainingDayDto;
//import com.ggymserver.entity.TrainingDay;
//import org.mapstruct.*;
//
//@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        componentModel = MappingConstants.ComponentModel.SPRING,
//        uses = {PlannedTrainingMapper.class}
//)
//public interface TrainingDayMapper {
//    TrainingDay toEntity(TrainingDayDto trainingDayDto);
//
//    @AfterMapping
//    default void linkTrainings (@MappingTarget TrainingDay trainingDay, TrainingDayDto dto) {
//        if(dto.plannedTrainings() != null && !dto.plannedTrainings().isEmpty()) {
//            trainingDay.getPlannedTrainings().forEach(training -> training.setTrainingDay(trainingDay));
//        }
//    }
//}