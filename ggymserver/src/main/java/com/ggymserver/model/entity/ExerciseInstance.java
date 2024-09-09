package com.ggymserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exercise_instance")
@Getter
@Setter
public class ExerciseInstance {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;


    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;
}
