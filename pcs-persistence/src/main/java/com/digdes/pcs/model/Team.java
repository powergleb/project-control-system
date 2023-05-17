package com.digdes.pcs.model;

import com.digdes.pcs.util.enums.RoleInTeam;

import java.util.Map;
import java.util.UUID;

public class Team {
    private UUID id;
    private Map<RoleInTeam, Employee> teammates;
    private Project project;
}
