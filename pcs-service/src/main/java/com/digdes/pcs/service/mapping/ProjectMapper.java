package com.digdes.pcs.service.mapping;

import com.digdes.pcs.core.dto.project.EditProjectDto;
import com.digdes.pcs.core.dto.project.ShowProjectDto;
import com.digdes.pcs.persistence.model.Project;

public class ProjectMapper {
    public static Project createEntity(EditProjectDto projectDto) {
        Project project = new Project();
        project.setCode(projectDto.getCode());
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return project;
    }

    public static Project editEntity(EditProjectDto editProjectDto, Project projectOld) {
        if (editProjectDto.getCode() != null) projectOld.setCode(editProjectDto.getCode());
        if (editProjectDto.getName() != null) projectOld.setName(editProjectDto.getName());
        if (editProjectDto.getDescription() != null) projectOld.setDescription(editProjectDto.getDescription());
        return projectOld;
    }

    public static ShowProjectDto mapFromEntity(Project project) {
        ShowProjectDto projectDto = new ShowProjectDto();
        projectDto.setCode(project.getCode());
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setProjectStatus(project.getProjectStatus());
        return projectDto;
    }
}