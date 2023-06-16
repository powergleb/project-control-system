package com.digdes.pcs.client.controller;


import com.digdes.pcs.core.dto.task.EditTaskDto;
import com.digdes.pcs.core.dto.task.FindTaskDto;
import com.digdes.pcs.core.dto.task.ShowTaskDto;
import com.digdes.pcs.service.inteface.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
@Log4j2
@Tag(name = "TaskController", description = "Контроллер задачи")
public class TaskController {
    TaskService taskService;

    @Operation(summary = "Создание задачи")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowTaskDto create(@RequestBody EditTaskDto dto) {
        log.info("В методе контроллера Task::create");
        return taskService.create(dto);
    }

    @Operation(summary = "Изменение задачи")
    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowTaskDto edit(@RequestBody EditTaskDto dto) {
        log.info("В методе контроллера Task::edit");
        return taskService.edit(dto);
    }

    @Operation(summary = "Поиск задачи по текстовому значению по Наименованию задачи " +
            "с приминением фильтров:" +
            " Статус задачи, Исполнитель, Автор, период крайнего срока, период создания задачи")
    @PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowTaskDto> find(@RequestBody FindTaskDto dto) {
        log.info("В методе контроллера Task::find");
        return taskService.find(dto);
    }

    @Operation(summary = "Перевод задачи в следующую стадию: " +
            "Новая -> В работе -> Выполнена -> Закрыта")
    @PostMapping(value = "/shift", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowTaskDto shift(@RequestParam String taskName) {
        log.info("В методе контроллера Project::shift");
        return taskService.shiftStatus(taskName);
    }
}