package gruppe8.nebula.requests;

import gruppe8.nebula.models.Project;

public record TaskCreationRequest(Long id, Project projectId, Long parentId, String name) {

}
