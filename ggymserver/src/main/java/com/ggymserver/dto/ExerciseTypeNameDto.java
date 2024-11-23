package com.ggymserver.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.ggymserver.entity.ExerciseType}
 */
public record ExerciseTypeNameDto(@NotNull String name) implements Serializable {
}