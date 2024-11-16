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
@Table(name = "planned_training_day")
public class PlannedTrainingDay {
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
    private PlannedTrainingWeek plannedTrainingWeek;

    @Column(name = "notes")
    private String notes;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @OneToMany(mappedBy = "plannedTrainingDay")
    private Set<PlannedTraining> plannedTrainings = new LinkedHashSet<>();

}