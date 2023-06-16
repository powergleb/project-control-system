package com.digdes.pcs.core.dto.task;

import com.digdes.pcs.core.util.enums.TaskStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "Задача. Передача данных для операции поиска")
public class FindTaskDto {

    @Schema(description = "Наименование задачи")
    private String name;

    private TaskStatusEnum taskStatus;

    @Schema(description = "Исполнитель задачи")
    private String employee;

    @Schema(description = "Автор задачи")
    private String author;

    @Schema(description = "Крайний срок, нижняя граница фильтра")
    private LocalDate deadlineMin;

    @Schema(description = "Крайний срок, верхняя граница фильтра")
    private LocalDate deadlineMax;

    @Schema(description = "Дата создания, нижняя граница фильтра")
    private LocalDateTime dateCreatedMin;

    @Schema(description = "Дата создания, верхняя граница фильтра")
    private LocalDateTime dateCreatedMax;
}