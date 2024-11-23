package com.ggymserver.entity;

import com.ggymserver.dto.ExerciseTypeNameDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Exercise}
 */
public record ExerciseDto(@NotNull String name, String description, @NotNull Integer intensity,
                          Set<ExerciseTypeNameDto> exerciseTypes) implements Serializable {
}