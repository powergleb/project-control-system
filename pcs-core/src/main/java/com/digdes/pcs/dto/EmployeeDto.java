package com.digdes.pcs.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String id;
    private String name;
    private String lastname;
    private String patronymic;
    private String post;
    private String account;
    private String email;
    private String employeeStatus;
}