package com.digdes.pcs.service.impl.taskfilter;


import com.digdes.pcs.core.util.enums.TaskStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskFilter {
    private String name;
    private TaskStatusEnum taskStatus;
    private Employee employee;
    private Employee author;
    private LocalDate deadlineMin;
    private LocalDate deadlineMax;
    private LocalDateTime createDateMin;
    private LocalDateTime createDateMax;
}