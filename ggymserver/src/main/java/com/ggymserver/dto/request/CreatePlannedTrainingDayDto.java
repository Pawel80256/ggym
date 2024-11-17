package com.ggymserver.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * DTO for {@link com.ggymserver.entity.PlannedTrainingDay}
 */
public record CreatePlannedTrainingDayDto(
        String name,
        @NotNull Integer dayOfTheWeek,
        String notes,
        Set<CreatePlannedTrainingDto> plannedTrainings) implements Serializable {
}