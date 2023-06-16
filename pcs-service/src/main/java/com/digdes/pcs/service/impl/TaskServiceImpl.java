package com.digdes.pcs.service.impl;

import com.digdes.pcs.core.dto.task.EditTaskDto;
import com.digdes.pcs.core.dto.task.FindTaskDto;
import com.digdes.pcs.core.dto.task.ShowTaskDto;
import com.digdes.pcs.core.util.enums.TaskStatusEnum;
import com.digdes.pcs.persistence.model.Employee;
import com.digdes.pcs.persistence.model.Task;
import com.digdes.pcs.persistence.repository.EmployeeRepo;
import com.digdes.pcs.persistence.repository.TaskRepo;
import com.digdes.pcs.service.ampq.MessageConsumer;
import com.digdes.pcs.service.ampq.MessageProducer;
import com.digdes.pcs.service.impl.taskfilter.TaskFilter;
import com.digdes.pcs.service.impl.taskfilter.TaskSpecification;
import com.digdes.pcs.service.inteface.TaskService;
import com.digdes.pcs.service.mail.TestMailSender;
import com.digdes.pcs.service.mapping.TaskMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private EmployeeRepo employeeRepository;
    private TaskRepo taskRepository;
    private MessageProducer messageProducer;

    @Override
    public ShowTaskDto create(EditTaskDto taskDto) {
        Task task = TaskMapper.create(taskDto);
        Employee employee = employeeRepository.findByLogin(taskDto.getEmployee()).orElseThrow();
        task.setEmployee(employee);
        task.setTaskStatus(TaskStatusEnum.NEW);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            task.setAuthor(employeeRepository.findByLogin(authentication.getName()).orElseThrow());
        } else task.setAuthor(employee);
        task.setDateCreated(LocalDateTime.now());
        task.setLastModified(LocalDateTime.now());

        task.checkEstimate();

        taskRepository.save(task);
        if (employee.getEmail()!=null) {
            TestMailSender.address = employee.getEmail();
            MessageConsumer.messageText = "Hello, you assigned to task named: " + task.getName();
            messageProducer.sendMessage();
        }
        return TaskMapper.mapFromEntity(task);
    }

    @Override
    public ShowTaskDto edit(EditTaskDto editTaskDto) {
        Optional<Task> taskFromBase = taskRepository.findByName(editTaskDto.getName());
        if (taskFromBase.isPresent()) {
            Task taskToSave = TaskMapper.edit(editTaskDto, taskFromBase.get());
            if (editTaskDto.getEmployee() != null) {
                Employee employee = employeeRepository.findByLogin(editTaskDto.getEmployee()).orElseThrow();
                taskToSave.setEmployee(employee);
            }
            taskToSave.setLastModified(LocalDateTime.now());
            taskRepository.save(taskToSave);
            return TaskMapper.mapFromEntity(taskToSave);
        }
        return new ShowTaskDto();
    }

    @Override
    public ShowTaskDto shiftStatus(String projectName) {
        Optional<Task> taskFromBase = taskRepository.findByName(projectName);
        if (taskFromBase.isPresent()) {
            Task task = taskFromBase.get();
            switch (task.getTaskStatus()) {
                case NEW -> task.setTaskStatus(TaskStatusEnum.IN_PROGRESS);
                case IN_PROGRESS -> task.setTaskStatus(TaskStatusEnum.DONE);
                case DONE -> task.setTaskStatus(TaskStatusEnum.CLOSED);
            }
            taskRepository.save(task);
            return TaskMapper.mapFromEntity(task);
        }
        return new ShowTaskDto();
    }

    @Override
    public List<ShowTaskDto> find(FindTaskDto dto) {
        Pageable firstPageWithTenElements = PageRequest.of(0, 10, Sort.by("createDate").descending());
        List<ShowTaskDto> result = new ArrayList<>();
        TaskFilter taskFilter = new TaskFilter();
        taskFilter.setTaskStatus(dto.getTaskStatus());

        if (!ObjectUtils.isEmpty(dto.getEmployee())) {
            Optional<Employee> employee = employeeRepository.findByLogin(dto.getEmployee());
            if (employee.isEmpty()) return result;
            else taskFilter.setEmployee(employee.orElseThrow());
        }

        if (!ObjectUtils.isEmpty(dto.getAuthor())) {
            Optional<Employee> author = employeeRepository.findByLogin(dto.getAuthor());
            if (author.isEmpty()) return result;
            else taskFilter.setAuthor(author.orElseThrow());
        }

        taskFilter.setDeadlineMin(dto.getDeadlineMin());
        taskFilter.setDeadlineMax(dto.getDeadlineMax());
        taskFilter.setCreateDateMin(dto.getDateCreatedMin());
        taskFilter.setCreateDateMax(dto.getDateCreatedMax());

        List<Task> tasks = taskRepository.findAll(TaskSpecification.getSpec(taskFilter), firstPageWithTenElements).toList();

        tasks.forEach(o -> result.add(TaskMapper.mapFromEntity(o)));

        return result;
    }

}

