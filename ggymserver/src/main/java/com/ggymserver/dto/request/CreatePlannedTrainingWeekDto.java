package com.ggymserver.dto.request;

import com.ggymserver.entity.PlannedTrainingWeek;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link PlannedTrainingWeek}
 */
public record CreatePlannedTrainingWeekDto(
        @NotNull Integer sequence,
        Set<CreatePlannedTrainingDayDto> plannedTrainingDays) implements Serializable {
}