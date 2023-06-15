package com.digdes.pcs.service.impl;

import com.digdes.pcs.core.dto.project.EditProjectDto;
import com.digdes.pcs.core.dto.project.FindProjectDto;
import com.digdes.pcs.core.dto.project.ShowProjectDto;
import com.digdes.pcs.core.util.enums.ProjectStatusEnum;
import com.digdes.pcs.persistence.model.Project;
import com.digdes.pcs.persistence.repository.ProjectRepo;
import com.digdes.pcs.service.inteface.ProjectService;
import com.digdes.pcs.service.mapping.ProjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    private ProjectRepo projectRepository;

    @Override
    public ShowProjectDto create(EditProjectDto projectDto) {
        Project project = ProjectMapper.createEntity(projectDto);
        project.setProjectStatus(ProjectStatusEnum.DRAFT);
        projectRepository.save(project);
        return ProjectMapper.mapFromEntity(project);
    }

    @Override
    public ShowProjectDto edit(EditProjectDto projectDto) {
        Optional<Project> projectFromBase = projectRepository.findByCode(projectDto.getCode());
        if (projectFromBase.isPresent()) {
            Project project = ProjectMapper.editEntity(projectDto, projectFromBase.get());
            projectRepository.save(project);
            return ProjectMapper.mapFromEntity(project);
        }
        return new ShowProjectDto();
    }

    @Override
    public List<ShowProjectDto> find(FindProjectDto findProjectDto) {
        List<Project> projectList = projectRepository.find(
                findProjectDto.getStatuses(),
                findProjectDto.getInput());
        List<ShowProjectDto> result = new ArrayList<>();

        projectList.forEach(o -> result.add(ProjectMapper.mapFromEntity(o)));

        return result;
    }

    @Override
    public ShowProjectDto shiftStatus(String projectCode) {
        Optional<Project> projectFromBase = projectRepository.findByCode(projectCode);
        if (projectFromBase.isPresent()) {
            Project project = projectFromBase.get();
            switch (project.getProjectStatus()) {
                case DRAFT -> project.setProjectStatus(ProjectStatusEnum.DRAFT);
                case IN_DEVELOPMENT -> project.setProjectStatus(ProjectStatusEnum.IN_TESTING);
                case IN_TESTING -> project.setProjectStatus(ProjectStatusEnum.COMPLETED);
            }
            projectRepository.save(project);
            return ProjectMapper.mapFromEntity(project);
        }
        return new ShowProjectDto();
    }
}
