package model;

import lombok.Data;
import util.ProjectStatus;

import java.util.ArrayList;

@Data
public class Project {
    private String code;
    private String name;
    private String description;
    private ProjectStatus projectStatus;
    private ArrayList <TeamMember> teamMembers;
}
