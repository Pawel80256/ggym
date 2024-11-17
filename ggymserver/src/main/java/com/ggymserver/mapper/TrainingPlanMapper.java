package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreatePlannedTrainingDayDto;
import com.ggymserver.dto.request.CreateTrainingPlanDto;
import com.ggymserver.entity.TrainingPlan;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PlannedTrainingWeekMapper.class}
)
public interface TrainingPlanMapper {
    TrainingPlan toEntity(CreateTrainingPlanDto createTrainingPlanDto);

    @AfterMapping
    default void linkWeeks (@MappingTarget TrainingPlan trainingPlan, CreateTrainingPlanDto dto){
        if(dto.plannedTrainingWeeks() != null && !dto.plannedTrainingWeeks().isEmpty()){
            trainingPlan.getPlannedTrainingWeeks().forEach(week -> {week.setTrainingPlan(trainingPlan);});
        }
    }
}