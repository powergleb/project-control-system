package com.digdes.pcs.persistence.model;

import com.digdes.pcs.core.util.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity(name="Task")
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="complexity", nullable = false)
    private Long complexity;

    @Column(name="date_created", nullable = false)
    private LocalDate dateCreated;

    @Column(name="deadline", nullable = false)
    private LocalDate deadline;

    @Column(name="last_modified", nullable = false)
    private LocalDate lastModified;

    @Column(name="task_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum taskStatus;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}
