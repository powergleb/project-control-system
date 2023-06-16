package com.digdes.pcs.service.mapping;



import com.digdes.pcs.core.dto.task.EditTaskDto;
import com.digdes.pcs.core.dto.task.ShowTaskDto;
import com.digdes.pcs.persistence.model.Task;

import java.time.LocalDate;

public class TaskMapper {
    public static Task create(EditTaskDto editTaskDto) {
        Task task = new Task();
        task.setName(editTaskDto.getName());
        task.setDescription(editTaskDto.getDescription());
        task.setComplexity(editTaskDto.getComplexity());
        task.setDeadline(LocalDate.parse(editTaskDto.getDeadline()));
        return task;
    }

    public static ShowTaskDto mapFromEntity(Task task) {
        ShowTaskDto showTaskDto = new ShowTaskDto();
        showTaskDto.setName(task.getName());
        showTaskDto.setDescription(task.getDescription());
        showTaskDto.setEmployee(task.getEmployee().getLogin());
        showTaskDto.setComplexity(task.getComplexity());
        showTaskDto.setDeadline(task.getDeadline().toString());
        showTaskDto.setTaskStatus(task.getTaskStatus());
        showTaskDto.setAuthor(task.getAuthor().getLogin());
        showTaskDto.setDateCreated(task.getDateCreated().toString());
        showTaskDto.setLastModified(task.getLastModified().toString());

        return showTaskDto;
    }

    public static Task edit(EditTaskDto taskDto, Task taskOld) {
        if (taskDto.getName() != null) taskOld.setName(taskDto.getName());
        if (taskDto.getDescription() != null) taskOld.setDescription(taskDto.getDescription());
        if (taskDto.getComplexity() != 0) taskOld.setComplexity(taskDto.getComplexity());
        if (taskDto.getDeadline() != null) taskOld.setDeadline(LocalDate.parse(taskDto.getDeadline()));
        return taskOld;
    }
}