package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.ProjectDTOResponse;
import ubb.postuniv.Project2021.model.dto.TaskDTOResponse;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

@Component
public class ProjectResponseMapper extends AbstractMapper<Project, ProjectDTOResponse> {

    @Autowired
    Mapper<Task, TaskDTOResponse> taskMapper;


    @Override
    public Project convertDtoToModel(ProjectDTOResponse projectDTOResponse) {

        List<Task> taskList = taskMapper.convertDtosToModels(projectDTOResponse.getTasks());

        return new Project(projectDTOResponse.getProjectCode(),
                projectDTOResponse.getTitle(),
                projectDTOResponse.getDescription(),
                projectDTOResponse.getDateAdded(),
                projectDTOResponse.getDeadline(),
                ProjectStatus.valueOf(projectDTOResponse.getProjectStatus().toUpperCase()),
                taskList);
    }

    @Override
    public ProjectDTOResponse convertModelToDto(Project project) {

        List<TaskDTOResponse> taskDTORequestList = taskMapper.convertModelsToDtos(project.getTasks());

        String createdBy = project.getAppUser().getFirstName() + " " + project.getAppUser().getLastName();

        return new ProjectDTOResponse(project.getProjectCode(),
                project.getTitle(),
                project.getDescription(),
                project.getDateAdded(),
                project.getDeadline(),
                project.getProjectStatus().getProjectStatus(),
                createdBy,
                taskDTORequestList);
    }
}
