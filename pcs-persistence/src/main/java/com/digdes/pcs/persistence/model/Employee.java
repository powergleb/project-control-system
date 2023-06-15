package com.digdes.pcs.persistence.model;



import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity(name = "Employee")
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "patronymic", nullable = true)
    private String patronymic;


/*    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "employee_post_id", referencedColumnName = "id")
    private EmployeePost employeePost;*/


    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employee_post", nullable = true)
    private String employeePost;

/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;*/

    @Column(name = "email", nullable = true)
    private String email;


    @Column(name = "employeeStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployeeStatusEnum employeeStatus;



}
