package org.resource.pipeline.system.valueobject;

import java.util.UUID;

public class ProjectId extends BaseId<UUID>{
    protected ProjectId(UUID value) {
        super(value);
    }
}
