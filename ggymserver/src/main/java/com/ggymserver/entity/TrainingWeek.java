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
//@Table(name = "planned_training_week")
//public class TrainingWeek {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "training_plan_id", nullable = false)
//    private TrainingPlan trainingPlan;
//
//    @NotNull
//    @Column(name = "sequence", nullable = false)
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
//    @OneToMany(mappedBy = "trainingWeek", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<TrainingDay> trainingDays = new LinkedHashSet<>();
//
//    public void addTrainingDay (TrainingDay trainingDay) {
//        this.trainingDays.add(trainingDay);
//        trainingDay.setTrainingWeek(this);
//    }
//}