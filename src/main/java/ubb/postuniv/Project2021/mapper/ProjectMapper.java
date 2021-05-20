package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.ProjectDTO;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

@Component
public class ProjectMapper extends AbstractMapper<Project, ProjectDTO> {

    @Autowired
    Mapper<Task, TaskDTO> taskMapper;

    @Override
    public Project convertDtoToModel(ProjectDTO projectDTO) {

        List<Task> taskList = taskMapper.convertDtosToModels(projectDTO.getTasks());

        return new Project(projectDTO.getProjectCode(), projectDTO.getTitle(), projectDTO.getDescription(), projectDTO.getDateAdded(), projectDTO.getDeadline(), projectDTO.getProjectStatus(), projectDTO.getAddedByUserCode(), taskList);
    }

    @Override
    public ProjectDTO convertModelToDto(Project project) {

        List<TaskDTO> taskDTOList = taskMapper.convertModelsToDtos(project.getTasks());

        return new ProjectDTO(project.getProjectCode(), project.getTitle(), project.getDescription(), project.getDateAdded(), project.getDeadline(), project.getProjectStatus(), project.getAddedByUserCode(), taskDTOList);
    }
}
