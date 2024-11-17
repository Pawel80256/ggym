package com.ggymserver.mapper;

import com.ggymserver.dto.request.CreateTrainingPlanDto;
import com.ggymserver.entity.TrainingPlan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrainingPlanMapper {
    TrainingPlan toEntity(CreateTrainingPlanDto createTrainingPlanDto);
}