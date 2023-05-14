package com.digdes.repository;

import com.digdes.model.Employee;
import com.digdes.util.exception.DALException;

import java.util.List;
import java.util.UUID;


public interface EmployeeRepo {
    void create(Employee employee) throws DALException;
    Employee getById(UUID id) throws DALException;
    List<Employee> getAll() throws DALException;
    void deleteById(UUID id) throws DALException;
}