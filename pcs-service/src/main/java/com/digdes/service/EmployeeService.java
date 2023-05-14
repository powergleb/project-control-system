package com.digdes.service;

import com.digdes.dto.EmployeeDto;
import com.digdes.model.Employee;
import com.digdes.util.exception.BLLException;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee create(EmployeeDto dto) throws BLLException;
    Employee getById(UUID id) throws BLLException;
    List<Employee> getAll() throws BLLException;
    void deleteById(UUID id) throws BLLException;
    Employee dtoToEmployee(EmployeeDto dto);
    EmployeeDto employeeToDto(Employee employee);
    List<EmployeeDto> employeeListToDto(List<Employee> employees);
}