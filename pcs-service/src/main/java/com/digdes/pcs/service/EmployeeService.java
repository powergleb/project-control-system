package com.digdes.pcs.service;

import com.digdes.pcs.dto.EmployeeDto;
import com.digdes.pcs.model.Employee;
import com.digdes.pcs.util.exception.BLLException;

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