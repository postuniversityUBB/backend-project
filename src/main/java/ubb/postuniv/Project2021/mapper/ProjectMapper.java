package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.ProjectDTORequest;
import ubb.postuniv.Project2021.model.dto.TaskDTORequest;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

@Component
public class ProjectMapper extends AbstractMapper<Project, ProjectDTORequest> {

    @Autowired
    Mapper<Task, TaskDTORequest> taskMapper;

    @Override
    public Project convertDtoToModel(ProjectDTORequest projectDTORequest) {

        List<Task> taskList = taskMapper.convertDtosToModels(projectDTORequest.getTasks());

        return new Project(projectDTORequest.getProjectCode(), projectDTORequest.getTitle(), projectDTORequest.getDescription(), projectDTORequest.getDateAdded(), projectDTORequest.getDeadline(), ProjectStatus.valueOf(projectDTORequest.getProjectStatus().toUpperCase()), projectDTORequest.getAddedByUserCode(), taskList);
    }

    @Override
    public ProjectDTORequest convertModelToDto(Project project) {

        List<TaskDTORequest> taskDTORequestList = taskMapper.convertModelsToDtos(project.getTasks());

        return new ProjectDTORequest(project.getProjectCode(), project.getTitle(), project.getDescription(), project.getDateAdded(), project.getDeadline(), project.getProjectStatus().getProjectStatus(), project.getAddedByUserCode(), taskDTORequestList);
    }
}
