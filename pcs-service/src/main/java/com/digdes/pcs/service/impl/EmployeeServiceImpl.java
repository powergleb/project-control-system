package com.digdes.pcs.service.impl;

import com.digdes.pcs.core.dto.employee.CreateEmployeeDto;
import com.digdes.pcs.core.dto.employee.EditEmployeeDto;
import com.digdes.pcs.core.dto.employee.ShowEmployeeDto;
import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import com.digdes.pcs.persistence.repository.EmployeeRepo;
import com.digdes.pcs.service.inteface.EmployeeService;
import com.digdes.pcs.service.mapping.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ShowEmployeeDto create(CreateEmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.createEntity(employeeDto);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setEmployeeStatus(EmployeeStatusEnum.ACTIVE);
        employeeRepository.save(employee);
        return EmployeeMapper.mapFromEntity(employee);
    }

    @Override
    public ShowEmployeeDto edit(EditEmployeeDto employeeDto) {
        Optional<Employee> employeeFromBase = employeeRepository.findByLoginAndEmployeeStatus(employeeDto.getLogin(), EmployeeStatusEnum.ACTIVE);
        if (employeeFromBase.isPresent()) {
            Employee employeeToSave = EmployeeMapper.editEntity(employeeDto, employeeFromBase.get());
            employeeRepository.save(employeeToSave);
            return EmployeeMapper.mapFromEntity(employeeToSave);
        }
        return new ShowEmployeeDto();
    }

    @Override
    public ShowEmployeeDto delete(UUID id) {
        Employee employee = employeeRepository.getReferenceById(id);
        employee.setEmployeeStatus(EmployeeStatusEnum.REMOVED);
        employeeRepository.save(employee);
        return EmployeeMapper.mapFromEntity(employee);
    }

    @Override
    public List<ShowEmployeeDto> find(String input) {
        Pageable firstPageWithTenElements = PageRequest.of(0, 10);
        Page<Employee> employeeList = employeeRepository.findByEmployeeStatusAndLastNameContainingOrNameContainingOrPatronymicContainingOrLoginContainingOrEmailContaining(
                EmployeeStatusEnum.ACTIVE,
                input,
                input,
                input,
                input,
                input,
                firstPageWithTenElements);
        List<ShowEmployeeDto> result = new ArrayList<>();

        employeeList.forEach(o ->  result.add(EmployeeMapper.mapFromEntity(o)));
        return result;
    }


    @Override
    public ShowEmployeeDto get(UUID id) {
        return EmployeeMapper.mapFromEntity(employeeRepository.getReferenceById(id));
    }

    @Override
    public ShowEmployeeDto get(String login) {
        return EmployeeMapper.mapFromEntity(employeeRepository.findByLogin(login).orElseThrow());
    }
}
