package com.digdes.repository.impl;

import com.digdes.model.Employee;
import com.digdes.repository.EmployeeRepo;
import com.digdes.util.exception.DALException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeRepoFile implements EmployeeRepo {
    private List<Employee> employeeCash;
    private String STORAGE_PATH = "employees.txt";

    {
        employeeCash = new ArrayList<>();
    }

    @Override
    public void create(Employee employee) throws DALException {
        if (!Files.exists(Path.of(STORAGE_PATH))) {
            try {
                Files.createFile(Path.of(STORAGE_PATH));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))) {
            employeeCash.add(employee);
            os.writeObject(employeeCash);
        } catch (FileNotFoundException e) {
            throw new DALException(e.getMessage());
        } catch (IOException e) {
            throw new DALException("Error creating employee: ", e);
        }
    }

    @Override
    public Employee getById(UUID id) throws DALException {
        Employee employee = getByIdFromCash(id);

        if (employee == null) {
            if (Files.exists(Path.of(STORAGE_PATH))) {
                try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH))) {
                    employeeCash = (List<Employee>) is.readObject();
                    employee = getByIdFromCash(id);
                    if (employee == null) {
                        throw new DALException("No employee with id: " + id.toString());
                    }
                } catch (FileNotFoundException e) {
                    throw new DALException(e.getMessage());
                } catch (IOException e) {
                    throw new DALException("Error getting employee: ", e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new DALException("No employee with id: " + id.toString());
            }
        }
        return employee;
    }

    private Employee getByIdFromCash(UUID id) {
        return employeeCash.stream().
                filter(e -> e.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public List<Employee> getAll() throws DALException {
        if (Files.exists(Path.of(STORAGE_PATH))) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH))) {
                employeeCash = (List<Employee>) is.readObject();
            } catch (FileNotFoundException e) {
                throw new DALException(e.getMessage());
            } catch (IOException e) {
                throw new DALException("Error getting employees: ", e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return new ArrayList<>(employeeCash);
    }

    @Override
    public void deleteById(UUID id) throws DALException {
        if (!Files.exists(Path.of(STORAGE_PATH))) {
            throw new DALException("No employee with id: " + id.toString());
        }

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH));
             ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))) {
            Employee employee = getByIdFromCash(id);
            if (employee == null) {
                employeeCash = (List<Employee>) is.readObject();
            }

            employee = getByIdFromCash(id);
            if (employee == null) {
                throw new DALException("No employee with id: " + id.toString());
            } else {
                employeeCash.remove(employee);
                os.writeObject(employeeCash);
            }
        } catch (FileNotFoundException e) {
            throw new DALException(e.getMessage());
        } catch (IOException e) {
            throw new DALException("Error deleting employee: ", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}