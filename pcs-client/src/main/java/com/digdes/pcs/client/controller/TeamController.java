package com.digdes.pcs.client.controller;

import com.digdes.pcs.core.dto.teammember.CreateTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.DeleteTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.ShowTeamMemberDto;
import com.digdes.pcs.service.inteface.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@AllArgsConstructor
@Log4j2
@Tag(name = "TeamController", description = "Контроллер команды")
public class TeamController {
    TeamService teamService;

    @Operation(summary = "Добавление участника")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowTeamMemberDto add(@RequestBody CreateTeamMemberDto dto) {
        log.info("В методе контроллера Crew::add");
        return teamService.add(dto);
    }

    @Operation(summary = "Удаление участника проекта")
    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowTeamMemberDto delete(@RequestBody DeleteTeamMemberDto dto) {
        log.info("В методе контроллера Crew::delete");
        return teamService.delete(dto);
    }

    @Operation(summary = "Получение участников по проекту")
    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowTeamMemberDto> get(@PathVariable String code) {
        log.info("В методе контроллера Crew::get");
        return teamService.getByProject(code);
    }
}