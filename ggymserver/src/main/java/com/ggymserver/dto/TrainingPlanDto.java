package com.ggymserver.dto;

import com.ggymserver.entity.TrainingPlan;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link TrainingPlan}
 */
public record TrainingPlanDto(
        @NotBlank String name,
        Set<TrainingWeekDto> trainingWeeks) implements Serializable {
  }