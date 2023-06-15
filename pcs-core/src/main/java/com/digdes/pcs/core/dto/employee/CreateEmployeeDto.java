package com.digdes.pcs.core.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сотрудник. Передача данных для создания")
public class CreateEmployeeDto {

    @Schema(description = "Имя")
    private String name;
    @Schema(description = "Фамилия")
    private String lastName;
    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Должность")
    private String employeePost;

    @Schema(description = "Адрес электронной почты")
    private String email;

    @Schema(description = "Логин")
    private String login;

    @Schema(name = "Пароль")
    private String password;





}