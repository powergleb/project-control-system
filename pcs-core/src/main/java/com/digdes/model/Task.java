package com.digdes.model;

import com.digdes.util.enums.TaskStatus;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Task {
    private UUID id;
    private String displayName;
    private Long complexity;
    private Date dateCreated;
    private Date deadline;
    private Date lastModified;
    private TaskStatus taskStatus;
    private Employee executor;
    private Employee author;

}
