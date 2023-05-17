package com.digdes.pcs.service.impl;


import com.digdes.pcs.dto.EmployeeDto;
import com.digdes.pcs.model.Employee;
import com.digdes.pcs.repository.EmployeeRepo;
import com.digdes.pcs.service.EmployeeService;
import com.digdes.pcs.util.enums.EmployeeStatus;

import com.digdes.pcs.util.exception.BLLException;
import com.digdes.pcs.util.exception.DALException;

import java.util.ArrayList;
        import java.util.List;
        import java.util.UUID;

public class EmployeeServiceFile implements EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeServiceFile(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee create(EmployeeDto dto) throws BLLException {
        Employee employee = dtoToEmployee(dto);
        employee.setId(UUID.randomUUID());
        try{
            employeeRepo.create(employee);
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }

        return employee;
    }

    @Override
    public Employee getById(UUID id) throws BLLException {
        try {
            return employeeRepo.getById(id);
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    @Override
    public List<Employee> getAll() throws BLLException {
        try {
            return employeeRepo.getAll();
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(UUID id) throws BLLException {
        try {
            employeeRepo.deleteById(id);
        }catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    public Employee dtoToEmployee(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setLastname(dto.getLastname());
        employee.setPatronymic(dto.getPatronymic());
        employee.setEmail(dto.getEmail());
        employee.setAccount(dto.getAccount());
        employee.setEmployeeStatus(EmployeeStatus.valueOf(dto.getEmployeeStatus().toUpperCase()));
        return employee;
    }

    public EmployeeDto employeeToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setName(employee.getName());
        dto.setLastname(employee.getLastname());
        dto.setPatronymic(employee.getPatronymic());
        dto.setAccount(employee.getAccount());
        dto.setEmployeeStatus(employee.getEmployeeStatus().toString());
        dto.setEmail(employee.getEmail());
        return dto;
    }

    public List<EmployeeDto> employeeListToDto(List<Employee> employees){
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee e : employees){
            employeeDtos.add(employeeToDto(e));
        }

        return employeeDtos;
    }
}