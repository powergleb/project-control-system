package com.digdes.pcs.service.mapping;


import com.digdes.pcs.core.dto.employee.CreateEmployeeDto;
import com.digdes.pcs.core.dto.employee.EditEmployeeDto;
import com.digdes.pcs.core.dto.employee.ShowEmployeeDto;
import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import com.digdes.pcs.persistence.model.Employee;

public class EmployeeMapper {
    public static Employee createEntity(CreateEmployeeDto createEmployeeDto) {
        Employee employee = new Employee();
        employee.setLastName(createEmployeeDto.getLastName());
        employee.setName(createEmployeeDto.getName());
        employee.setPatronymic(createEmployeeDto.getPatronymic());
        employee.setEmployeePost(createEmployeeDto.getEmployeePost());
        employee.setLogin(createEmployeeDto.getLogin());
        employee.setEmail(createEmployeeDto.getEmail());
        employee.setEmployeeStatus(EmployeeStatusEnum.ACTIVE);
        employee.setPassword(createEmployeeDto.getPassword());
        return employee;
    }

    public static Employee editEntity(EditEmployeeDto editEmployeeDto, Employee employeeOld) {
        if (editEmployeeDto.getLastName() != null) employeeOld.setLastName(editEmployeeDto.getLastName());
        if (editEmployeeDto.getName() != null) employeeOld.setName(editEmployeeDto.getName());
        if (editEmployeeDto.getPatronymic() != null) employeeOld.setPatronymic(editEmployeeDto.getPatronymic());
        if (editEmployeeDto.getEmployeePost() != null) employeeOld.setEmployeePost(editEmployeeDto.getEmployeePost());
        if (editEmployeeDto.getLogin() != null) employeeOld.setLogin(editEmployeeDto.getLogin());
        if (editEmployeeDto.getEmail() != null) employeeOld.setEmail(editEmployeeDto.getEmail());
        return employeeOld;
    }

    public static ShowEmployeeDto mapFromEntity(Employee employee) {
        ShowEmployeeDto employeeDto = new ShowEmployeeDto();
        employeeDto.setShowName(employee.getLastName()
                + " "
                + employee.getName()
                + " "
                + employee.getPatronymic()
        );
        employeeDto.setEmployeePost(employee.getEmployeePost());
        employeeDto.setLogin(employee.getLogin());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setEmployeeStatus(employee.getEmployeeStatus());
        return employeeDto;
    }
}