package com.ggymserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "planned_training_day")
public class TrainingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "day_of_the_week", nullable = false)
    private Integer dayOfTheWeek;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planned_training_week_id", nullable = false)
    private TrainingWeek trainingWeek;

    @Column(name = "notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @OneToMany(mappedBy = "trainingDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlannedTraining> plannedTrainings = new LinkedHashSet<>();

    public void addPlannedTraining(PlannedTraining plannedTraining) {
        plannedTrainings.add(plannedTraining);
        plannedTraining.setTrainingDay(this);
    }
}