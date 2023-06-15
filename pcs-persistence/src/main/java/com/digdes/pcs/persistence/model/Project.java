package com.digdes.pcs.persistence.model;

import com.digdes.pcs.core.util.enums.ProjectStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;
@Data
@Entity(name="Project")
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name="code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name="description", nullable = true)
    private String description;

    @Column(name="project_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatusEnum projectStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Task> tasks;
}