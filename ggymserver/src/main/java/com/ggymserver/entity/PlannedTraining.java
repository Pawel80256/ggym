//package com.ggymserver.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "planned_training")
//public class PlannedTraining {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "planned_training_day_id", nullable = false)
//    private TrainingDay trainingDay;
//
//    @Column(name = "sequence")
//    private Integer sequence;
//
//    @CreationTimestamp
//    @Column(name = "created", nullable = false)
//    private LocalDateTime created;
//
//    @UpdateTimestamp
//    @Column(name = "modified", nullable = false)
//    private LocalDateTime modified;
//
//    @OneToMany(mappedBy = "plannedTraining", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<PlannedExercise> plannedExercises = new LinkedHashSet<>();
//
//    public void addPlannedExercise(PlannedExercise plannedExercise) {
//        plannedExercises.add(plannedExercise);
//        plannedExercise.setPlannedTraining(this);
//    }
//}