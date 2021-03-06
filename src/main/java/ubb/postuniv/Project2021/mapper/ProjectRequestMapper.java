package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.ProjectDTORequest;
import ubb.postuniv.Project2021.model.dto.TaskDTORequest;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

@Component
public class ProjectRequestMapper extends AbstractMapper<Project, ProjectDTORequest> {

    @Autowired
    Mapper<Task, TaskDTORequest> taskMapper;

    @Override
    public Project convertDtoToModel(ProjectDTORequest projectDTORequest) {


        return new Project(projectDTORequest.getTitle(),
                projectDTORequest.getDescription(),
                projectDTORequest.getDeadline(),
                ProjectStatus.valueOf(projectDTORequest.getProjectStatus().toUpperCase()));
    }

    @Override
    public ProjectDTORequest convertModelToDto(Project project) {

        return new ProjectDTORequest(project.getTitle(),
                project.getDescription(),
                project.getDeadline(),
                project.getProjectStatus().getProjectStatus());
    }
}
