package com.ggymserver.dto.request;

import com.ggymserver.entity.TrainingPlan;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link TrainingPlan}
 */
public record CreateTrainingPlanDto(
        @NotBlank String name,
        Set<CreateTrainingWeekDto> plannedTrainingWeeks) implements Serializable {
  }