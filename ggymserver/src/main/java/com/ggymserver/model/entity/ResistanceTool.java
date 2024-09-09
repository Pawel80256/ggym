package com.ggymserver.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resistance_tool")
@Getter
@Setter
public class ResistanceTool {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;
}
