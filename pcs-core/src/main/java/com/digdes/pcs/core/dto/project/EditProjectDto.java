package com.digdes.pcs.core.dto.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Проект. Передача данных для операции редактирования/создания")
public class EditProjectDto {

    @Schema(description = "Код проекта")
    private String code;

    @Schema(description = "Наименование проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String description;
}