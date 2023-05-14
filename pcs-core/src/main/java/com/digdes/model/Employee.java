package com.digdes.model;

import com.digdes.util.enums.EmployeeStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Employee implements Serializable {
    private UUID id;
    private String name;
    private String lastname;
    private String patronymic;
    private String post;
    private String account;
    private String email;
    private EmployeeStatus employeeStatus;
}
