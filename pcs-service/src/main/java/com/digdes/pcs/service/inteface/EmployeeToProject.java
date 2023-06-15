package com.digdes.pcs.service.inteface;

import com.digdes.pcs.core.dto.teammember.CreateTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.ShowTeamMemberDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeToProject {
    public ShowTeamMemberDto add(CreateTeamMemberDto addCrewDto);


}
