package model;

import lombok.Data;
import util.EmployeeStatus;

@Data
public class Employee {
    private String name;
    private String lastname;
    private String patronymic;
    private String post;
    private String account;
    private String email;
    private EmployeeStatus employeeStatus;
}
