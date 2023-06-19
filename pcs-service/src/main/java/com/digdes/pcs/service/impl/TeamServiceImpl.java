package com.digdes.pcs.service.impl;

import com.digdes.pcs.core.dto.teammember.CreateTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.DeleteTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.ShowTeamMemberDto;
import com.digdes.pcs.persistence.model.Employee;
import com.digdes.pcs.persistence.model.EmployeeToProject;
import com.digdes.pcs.persistence.model.Project;
import com.digdes.pcs.persistence.repository.EmployeeRepo;
import com.digdes.pcs.persistence.repository.EmployeeToProjectRepo;
import com.digdes.pcs.persistence.repository.ProjectRepo;
import com.digdes.pcs.service.inteface.TeamService;
import com.digdes.pcs.service.mapping.TeamMemberMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private EmployeeToProjectRepo employeeToProjectRepo;
    private EmployeeRepo employeeRepository;
    private ProjectRepo projectRepository;

    @Override
    public ShowTeamMemberDto add(CreateTeamMemberDto createTeamMemberDto) {
        EmployeeToProject employeeToProject = new EmployeeToProject();
        Project project = projectRepository.findByCode(createTeamMemberDto.getProjectCode()).orElseThrow();
        Employee employee = employeeRepository.findByLogin(createTeamMemberDto.getLogin()).orElseThrow();

        Optional<EmployeeToProject> projectAssignmentExist = employeeToProjectRepo.findByProjectIdAndEmployeeId(project.getId(), employee.getId());
        if (projectAssignmentExist.isPresent()) return new ShowTeamMemberDto();

        employeeToProject.setProject(project);
        employeeToProject.setEmployee(employee);
        employeeToProject.setRoleInTeam(createTeamMemberDto.getRoleInTeam());
        employeeToProjectRepo.save(employeeToProject);
        return TeamMemberMapper.mapFromEntity(employeeToProject);
    }

    @Override
    public ShowTeamMemberDto delete(DeleteTeamMemberDto deleteTeamMemberDto) {
        Project project = projectRepository.findByCode(deleteTeamMemberDto.getProjectCode()).orElseThrow();
        Employee employee = employeeRepository.findByLogin(deleteTeamMemberDto.getLogin()).orElseThrow();
        Optional<EmployeeToProject> employeeToProject = employeeToProjectRepo.findByProjectIdAndEmployeeId(project.getId(), employee.getId());
        if (employeeToProject.isPresent()) {
            employeeToProjectRepo.delete(employeeToProject.get());
            return TeamMemberMapper.mapFromEntity(employeeToProject.get());
        }
        return new ShowTeamMemberDto();
    }

    @Override
    public List<ShowTeamMemberDto> getByProject(String code) {
        Pageable firstPageWithTenElements = PageRequest.of(0, 10);
        List<ShowTeamMemberDto> result = new ArrayList<>();
        Project project = projectRepository.findByCode(code).orElseThrow();
        List<EmployeeToProject> projectAssignmentList = employeeToProjectRepo.findByProjectId(project.getId(), firstPageWithTenElements);

        projectAssignmentList.forEach(o -> result.add(TeamMemberMapper.mapFromEntity(o)));

        return result;
    }
}
