package com.ggymserver.model.entity;

import com.ggymserver.model.enums.ExerciseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercise")
@Getter
@Setter
public class Exercise {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExerciseType type;

    @Column(name = "intensity", nullable = false)
    @Min(1)
    @Max(10)
    private Integer intensity;

    @ManyToMany
    @JoinTable(
            name = "exercises_muscle_parts",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_part_id")
    )
    private Set<MusclePart> muscleParts = new HashSet<>();
}
