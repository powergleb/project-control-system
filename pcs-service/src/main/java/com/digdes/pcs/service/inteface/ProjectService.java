package com.digdes.pcs.service.inteface;

import com.digdes.pcs.core.dto.project.EditProjectDto;
import com.digdes.pcs.core.dto.project.FindProjectDto;
import com.digdes.pcs.core.dto.project.ShowProjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    public ShowProjectDto create(EditProjectDto projectDto);
    public ShowProjectDto edit(EditProjectDto projectDto);
    public List<ShowProjectDto> find(FindProjectDto findProjectDto);
    public ShowProjectDto shiftStatus(String projectCode);
}
