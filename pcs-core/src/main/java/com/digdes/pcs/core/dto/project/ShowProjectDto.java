package com.digdes.pcs.core.dto.project;


import com.digdes.pcs.core.util.enums.ProjectStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Проект. Передача данных по операциям поиска")
public class ShowProjectDto {

    @Schema(description = "Код проекта")
    private String code;

    @Schema(description = "Наименование проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String description;

    @Schema(description = "Статус проекта")
    private ProjectStatusEnum projectStatus;
}