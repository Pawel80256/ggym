package com.ggymserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "exercise_type")
public class ExerciseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @NaturalId
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @ManyToMany(mappedBy = "exerciseTypes")
    private Set<Exercise> exercises = new LinkedHashSet<>();

}