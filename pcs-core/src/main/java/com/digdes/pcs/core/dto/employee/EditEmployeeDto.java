package com.digdes.pcs.core.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сотрудник. Передача данных для редактирования")
public class EditEmployeeDto {

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Должность")
    private String employeePost;

    @Schema(description = "Учетная запись сотрудника")
    private String login;

    @Schema(description = "Адрес электронной почты")
    private String email;
}