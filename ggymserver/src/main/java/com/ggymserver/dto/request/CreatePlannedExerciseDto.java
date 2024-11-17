package com.ggymserver.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.ggymserver.entity.PlannedExercise}
 */
public record CreatePlannedExerciseDto(
        @NotNull Long exerciseId,
        Integer setsCount,
        Integer repsCount,
        Integer duration,
        Integer sequence) implements Serializable {
}