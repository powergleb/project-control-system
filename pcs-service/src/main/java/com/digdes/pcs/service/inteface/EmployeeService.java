package com.digdes.pcs.service.inteface;



import com.digdes.pcs.core.dto.employee.CreateEmployeeDto;
import com.digdes.pcs.core.dto.employee.EditEmployeeDto;
import com.digdes.pcs.core.dto.employee.ShowEmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EmployeeService {
    public ShowEmployeeDto create(CreateEmployeeDto employeeDto);
    public ShowEmployeeDto edit(EditEmployeeDto employeeDto);

    public ShowEmployeeDto delete(UUID id);
    public ShowEmployeeDto get(UUID id);

    public List<ShowEmployeeDto> find(String input);
    public ShowEmployeeDto get(String login);

}