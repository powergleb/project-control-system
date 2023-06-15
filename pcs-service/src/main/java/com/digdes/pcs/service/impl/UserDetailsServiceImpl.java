package com.digdes.pcs.service.impl;


import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import com.digdes.pcs.persistence.repository.EmployeeRepo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private EmployeeRepo employeeRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByLoginAndEmployeeStatus(login, EmployeeStatusEnum.ACTIVE)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(login, employee.getPassword(), Collections.emptyList());
    }

    @PostConstruct
    public void initAdmin() {
        Employee employee = new Employee();
        employee.setLastName("admin");
        employee.setName("admin");
        employee.setEmployeeStatus(EmployeeStatusEnum.ACTIVE);
        employee.setLogin("root");
        employee.setPassword(passwordEncoder.encode("root"));
        Optional<Employee> admin = employeeRepository.findByLogin("root");
        if (admin.isEmpty()) {
            employeeRepository.save(employee);
        }
    }
}