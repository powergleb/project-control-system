package com.digdes.model;

import lombok.Data;
import com.digdes.util.enums.ProjectStatus;

import java.util.UUID;

@Data
public class Project {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private ProjectStatus projectStatus;
}
