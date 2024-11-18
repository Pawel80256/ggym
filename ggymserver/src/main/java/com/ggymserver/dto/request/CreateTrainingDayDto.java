package com.ggymserver.dto.request;

import com.ggymserver.entity.TrainingDay;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link TrainingDay}
 */
public record CreateTrainingDayDto(
        String name,
        @NotNull Integer dayOfTheWeek,
        String notes,
        Set<CreatePlannedTrainingDto> plannedTrainings) implements Serializable {
}