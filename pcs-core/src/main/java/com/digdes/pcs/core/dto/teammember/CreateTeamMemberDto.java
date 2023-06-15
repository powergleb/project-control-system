package com.digdes.pcs.core.dto.teammember;

import com.digdes.pcs.core.util.enums.RoleInTeamEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Участник команды. Передача данных по операции добавления")
public class CreateTeamMemberDto {


    @Schema(description = "Код проекта")
    private String projectCode;

    @Schema(description = "Логин сотрудинка")
    private String login;

    @Schema(description = "Роль сотрудника в проекте")
    private RoleInTeamEnum roleInTeam;

}
