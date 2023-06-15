package com.digdes.pcs.core.dto.teammember;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Участник команды. Передача данных по операции удаления")
@Data
public class DeleteTeamMemberDto {

    @Schema(description = "Код проекта")
    private String projectCode;

    @Schema(description = "Логин сотрудинка")
    private String login;
}