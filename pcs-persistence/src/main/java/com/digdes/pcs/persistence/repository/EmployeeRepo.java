package com.digdes.pcs.persistence.repository;

import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, UUID> {


    Optional<Employee> findByLogin(String login);

    Optional<Employee> findByLoginAndEmployeeStatus(String login,EmployeeStatusEnum employeeStatusEnum);

    Page<Employee> findByEmployeeStatusAndLastNameContainingOrNameContainingOrPatronymicContainingOrLoginContainingOrEmailContaining(
            EmployeeStatusEnum employeeStatus,
            String infixLastname,
            String infixName,
            String infixPatronymic,
            String infixLogin,
            String infixEmail,
            Pageable pageable);

}