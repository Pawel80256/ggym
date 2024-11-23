package com.ggymserver.dto;

import com.ggymserver.entity.TrainingDay;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link TrainingDay}
 */
public record TrainingDayDto(
        String name,
        @NotNull Integer dayOfTheWeek,
        String notes,
        Set<PlannedTrainingDto> plannedTrainings) implements Serializable {
}