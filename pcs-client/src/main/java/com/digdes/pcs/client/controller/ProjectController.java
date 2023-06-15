package com.digdes.pcs.client.controller;



import com.digdes.pcs.core.dto.project.EditProjectDto;
import com.digdes.pcs.core.dto.project.FindProjectDto;
import com.digdes.pcs.core.dto.project.ShowProjectDto;
import com.digdes.pcs.service.inteface.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@AllArgsConstructor
@Log4j2
@Tag(name = "ProjectController", description = "Контроллер проекта")
public class ProjectController {
    ProjectService projectService;

    @Operation(summary = "Создание проекта")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowProjectDto create(@RequestBody EditProjectDto dto) {
        log.info("В методе контроллера Project::create");
        return projectService.create(dto);
    }

    @Operation(summary = "Изменение проекта")
    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowProjectDto edit(@RequestBody EditProjectDto dto) {
        log.info("В методе контроллера Project::edit");
        return projectService.edit(dto);
    }

    @Operation(summary = "Поиск проекта по текстовому значению, которое проверяется по атрибутам:" +
            " Наименование, Код" +
            " и списку фильтров по статусам проектов")
    @PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowProjectDto> find(@RequestBody FindProjectDto dto) {
        log.info("В методе контроллера Project::find");
        return projectService.find(dto);
    }

    @Operation(summary = "Перевод проекта в следующую стадию: " +
            "Черновик -> В разработке -> В тестировании -> Завершен")
    @PostMapping(value = "/shift", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowProjectDto shift(@RequestParam String projectCode) {
        log.info("В методе контроллера Project::shift");
        return projectService.shiftStatus(projectCode);
    }
}