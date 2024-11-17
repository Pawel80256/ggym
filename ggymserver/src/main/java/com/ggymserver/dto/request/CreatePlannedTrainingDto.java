package com.ggymserver.dto.request;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.ggymserver.entity.PlannedTraining}
 */
public record CreatePlannedTrainingDto(
        String name,
        String description,
        Integer sequence,
        Set<CreatePlannedExerciseDto> plannedExercises) implements Serializable {
}