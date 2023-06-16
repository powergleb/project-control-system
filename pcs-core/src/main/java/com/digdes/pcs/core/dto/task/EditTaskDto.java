package com.digdes.pcs.core.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Задача. Передача данных для операции редактирования/создания")
public class EditTaskDto {

    @Schema(description = "Наименование задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Исполнитель задачи")
    private String employee;

    @Schema(description = "Оценка трудозатрат в часах")
    private Long complexity;

    @Schema(description = "Крайний срок")
    private String deadline;
}