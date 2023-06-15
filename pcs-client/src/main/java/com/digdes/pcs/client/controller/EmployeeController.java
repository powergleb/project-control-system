package com.digdes.pcs.client.controller;

import com.digdes.pcs.core.dto.employee.CreateEmployeeDto;
import com.digdes.pcs.core.dto.employee.EditEmployeeDto;
import com.digdes.pcs.core.dto.employee.ShowEmployeeDto;
import com.digdes.pcs.service.inteface.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
@Log4j2
@Tag(name = "EmployeeController", description = "Контроллер сотрудника")
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Внесение сотрудника")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ShowEmployeeDto create(@RequestBody CreateEmployeeDto employeeDto) {
        log.info("В методе контроллера Employee::create");
        return employeeService.create(employeeDto);
    }

    @Operation(summary = "Изменение существующей записи о сотруднике")
    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ShowEmployeeDto edit(@RequestBody EditEmployeeDto employeeDto) {
        log.info("В методе контроллера Employee::edit");
        return employeeService.edit(employeeDto);
    }

    @Operation(summary = "Получение профиля по идентефикатору")
    @GetMapping(value = "/get_by_id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowEmployeeDto get(@PathVariable UUID id) {
        log.info("В методе контроллера Employee::getById");
        return employeeService.get(id);
    }

    @Operation(summary = "Получение профиля по учетной записи")
    @GetMapping(value = "/get_by_account/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowEmployeeDto get(@PathVariable String login) {
        log.info("В методе контроллера Employee::getByLogin");
        return employeeService.get(login);
    }

    @Operation(summary = "Поиск сотрудника по текстовому значению, которое проверяется по атрибутам:" +
            " Фамилия, Имя, Отчество, учетной записи, адресу электронной почты" +
            " и только среди активных сотрудников")
    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowEmployeeDto> find(@RequestParam String input) {
        log.info("В методе контроллера Employee::find");
        return employeeService.find(input);
    }

    @Operation(summary = "Удаление сотрудника, сотрудник переводится в статус REMOVED")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowEmployeeDto delete(@PathVariable UUID id) {
        log.info("В методе контроллера Employee::delete");
        return employeeService.delete(id);
    }
}