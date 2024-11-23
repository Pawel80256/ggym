package com.ggymserver.mapper;

import com.ggymserver.dto.request.TrainingPlanDto;
import com.ggymserver.entity.TrainingPlan;
import org.mapstruct.*;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {TrainingWeekMapper.class}
)
public interface TrainingPlanMapper {

    TrainingPlan toEntity(TrainingPlanDto trainingPlanDto);

    void toEntityUpdate(TrainingPlanDto trainingPlanDto, @MappingTarget TrainingPlan trainingPlan);

    TrainingPlanDto toDto(TrainingPlan trainingPlan);

    @AfterMapping
    default void linkWeeks (@MappingTarget TrainingPlan trainingPlan, TrainingPlanDto dto){
        if(dto.trainingWeeks() != null && !dto.trainingWeeks().isEmpty()){
            trainingPlan.getTrainingWeeks().forEach(week -> {week.setTrainingPlan(trainingPlan);});
        }
    }
}