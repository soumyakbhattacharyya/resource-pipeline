package org.resource.pipeline.system.project.service.domain.entity;

import org.resource.pipeline.system.entity.AggregateRoot;
import org.resource.pipeline.system.valueobject.BaseDateTime;
import org.resource.pipeline.system.valueobject.ProjectId;
import org.resource.pipeline.system.valueobject.ProjectStatus;
import org.resource.pipeline.system.valueobject.ProjectPriority;

public class Project extends AggregateRoot<ProjectId>{
    private ProjectId id;
    private String name;
    private String code;
    private String description;
    private String goal;
    private ProjectStatus status;
    private ProjectPriority projectPriority;
    private BaseDateTime startTime;
    private BaseDateTime endTime;
}
