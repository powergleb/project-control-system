package com.digdes.pcs.core.dto.employee;

import com.digdes.pcs.core.util.enums.EmployeeStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сотрудник. Передача данных по операциям поиска")
public class ShowEmployeeDto {

    @Schema(description = "Имя, фамилия, отчество сотрудника, отображаемое в ответ на запрос")
    private String showName;

    @Schema(description = "Должность")
    private String employeePost;

    @Schema(description = "Учетная запись сотрудника")
    private String login;

    @Schema(description = "Адрес электронной почты")
    private String email;

    @Schema(description = "Статус сотрудника (ACTIVE, REMOVED)")
    private EmployeeStatusEnum employeeStatus;
}