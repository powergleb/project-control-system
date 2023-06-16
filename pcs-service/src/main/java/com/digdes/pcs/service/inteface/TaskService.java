package com.digdes.pcs.service.inteface;


import com.digdes.pcs.core.dto.task.EditTaskDto;
import com.digdes.pcs.core.dto.task.FindTaskDto;
import com.digdes.pcs.core.dto.task.ShowTaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {


    public ShowTaskDto create(EditTaskDto taskDto) ;

    public ShowTaskDto edit(EditTaskDto editTaskDto) ;


    public ShowTaskDto shiftStatus(String projectName);


    public List<ShowTaskDto> find(FindTaskDto dto);



}
