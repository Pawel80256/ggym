package com.ggymserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training")
@Getter
@Setter
public class Training {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created")
    private LocalDateTime created;

    @OneToMany(mappedBy = "training") //todo: orphan removal, cascade etc
    private Set<ExerciseInstance> exerciseInstanceSet = new HashSet<>();
}
