package com.ggymserver.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exercise_set")
@Getter
@Setter
public class ExerciseSet {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_instance_id")
    private ExerciseInstance exerciseInstance;

    @ManyToOne
    @JoinColumn(name = "resistance_tool_id")
    private ResistanceTool resistanceTool;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;

    @Column(name = "comment")
    private String comment;

    @Column(name = "effort", nullable = false)
    @Min(1)
    @Max(10)
    private Integer effort;
}
