package com.digdes.pcs.core.dto.teammember;

import com.digdes.pcs.core.dto.employee.ShowEmployeeDto;
import com.digdes.pcs.core.util.enums.RoleInTeamEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Участник команды. Передача данных по операции поиска")
@Data
public class ShowTeamMemberDto {

    @Schema(description = "Сотрудник")
    private ShowEmployeeDto employeeDto;

    @Schema(description = "Роль сотрудника в проекте")
    private RoleInTeamEnum roleInTeam;
}