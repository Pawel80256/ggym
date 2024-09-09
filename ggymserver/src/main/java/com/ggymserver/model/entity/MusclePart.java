package com.ggymserver.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "muscle_part")
@Getter
@Setter
public class MusclePart {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToMany(mappedBy = "muscleParts")
    private Set<Exercise> exercises;
}
