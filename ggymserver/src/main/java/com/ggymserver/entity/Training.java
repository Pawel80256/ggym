package com.ggymserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('training_training_plan_id_seq')")
    @JoinColumn(name = "training_plan_id", nullable = false)
    private TrainingPlan trainingPlan;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "comment")
    private String comment;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @OneToMany(mappedBy = "training")
    private Set<ExerciseInstance> exerciseInstances = new LinkedHashSet<>();

}