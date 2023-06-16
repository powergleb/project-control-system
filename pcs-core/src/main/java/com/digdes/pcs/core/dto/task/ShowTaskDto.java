package com.digdes.pcs.core.dto.task;

import com.digdes.pcs.core.util.enums.TaskStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@Schema(description = "Задача. Передача данных по операциям поиска")
public class ShowTaskDto {

    @Schema(description = "Наименование задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Исполнитель задачи")
    private String employee;

    @Schema(description = "Оценка трудозатрат в часах")
    private Long complexity;

    @Schema(description = "Дедлайн")
    private String deadline;

    @Schema(description = "Статус задачи")
    private TaskStatusEnum taskStatus;

    @Schema(description = "Автор задачи")
    private String author;

    @Schema(description = "Дата создания")
    private String dateCreated;

    @Schema(description = "Дата изменения")
    private String lastModified;

}