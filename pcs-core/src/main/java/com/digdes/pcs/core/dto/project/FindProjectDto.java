package com.digdes.pcs.core.dto.project;


import com.digdes.pcs.core.util.enums.ProjectStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Проект. Передача данных для операции поиска")
public class FindProjectDto {

    @Schema(description = "Список статусов")
    private List<ProjectStatusEnum> statuses;

    @Schema(description = "Строка для поиска")
    private String input;
}