package com.digdes.model;

import com.digdes.util.TaskStatus;
import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Long id;
    private String displayName;
    private Long complexity;
    private Date dateCreated;
    private Date deadline;
    private Date lastModified;
    private TaskStatus taskStatus;
    private Employee author;


}
