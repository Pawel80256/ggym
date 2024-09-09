package com.ggymserver.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "load")
public class Load {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resistance_tool_id")
    private ResistanceTool resistanceTool;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "comment")
    private String comment;
}
