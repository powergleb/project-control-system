package com.digdes.pcs.service.mapping;


import com.digdes.pcs.core.dto.teammember.ShowTeamMemberDto;
import com.digdes.pcs.persistence.model.EmployeeToProject;

public class TeamMemberMapper {
    public static ShowTeamMemberDto mapFromEntity(EmployeeToProject employeeToProject) {
        ShowTeamMemberDto showTeamMemberDto = new ShowTeamMemberDto();
        showTeamMemberDto.setEmployeeDto(EmployeeMapper.mapFromEntity(employeeToProject.getEmployee()));
        showTeamMemberDto.setRoleInTeam(employeeToProject.getRoleInTeam());
        return showTeamMemberDto;
    }
}