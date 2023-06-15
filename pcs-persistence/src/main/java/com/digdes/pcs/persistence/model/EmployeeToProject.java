package com.digdes.pcs.persistence.model;

import com.digdes.pcs.core.util.enums.RoleInTeamEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Data
@Entity(name = "EmployeeToProject")
@Table(name = "employee_to_project")
public class EmployeeToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @Column(name = "role_in_team", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleInTeamEnum roleInTeam;
}