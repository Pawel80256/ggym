package com.ggymserver.dto.request;

import com.ggymserver.entity.TrainingWeek;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link TrainingWeek}
 */
public record CreateTrainingWeekDto(
        @NotNull Integer sequence,
        Set<CreateTrainingDayDto> trainingDays) implements Serializable {
}