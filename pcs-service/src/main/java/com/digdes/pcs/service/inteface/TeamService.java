package com.digdes.pcs.service.inteface;

import com.digdes.pcs.core.dto.teammember.CreateTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.DeleteTeamMemberDto;
import com.digdes.pcs.core.dto.teammember.ShowTeamMemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    public ShowTeamMemberDto add(CreateTeamMemberDto addCrewDto);
    public ShowTeamMemberDto delete(DeleteTeamMemberDto deleteCrewDto);

    public List<ShowTeamMemberDto> getByProject(String code);

}
