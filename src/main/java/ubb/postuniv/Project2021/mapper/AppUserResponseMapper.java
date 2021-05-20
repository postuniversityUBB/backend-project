package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.AppUserDTOResponse;
import ubb.postuniv.Project2021.model.dto.ProjectDTO;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;


@Component
public class AppUserResponseMapper extends AbstractMapper<AppUser, AppUserDTOResponse> {


    @Autowired
    Mapper<Project, ProjectDTO> projectMapper;

    @Autowired
    Mapper<Task, TaskDTO> taskMapper;

    @Override
    public AppUser convertDtoToModel(AppUserDTOResponse appUserDTOResponse) {

        List<Project> projectList = projectMapper.convertDtosToModels(appUserDTOResponse.getProjects());
        List<Task> taskList = taskMapper.convertDtosToModels(appUserDTOResponse.getTasks());

        return new AppUser(appUserDTOResponse.getUserCode(), appUserDTOResponse.getFirstName(), appUserDTOResponse.getLastName(), appUserDTOResponse.getEmail(), appUserDTOResponse.isAdmin(), projectList, taskList, appUserDTOResponse.getCreatedAt());
    }

    @Override
    public AppUserDTOResponse convertModelToDto(AppUser appUser) {

        List<ProjectDTO> projectDTOList = projectMapper.convertModelsToDtos(appUser.getProjects());
        List<TaskDTO> taskDTOList = taskMapper.convertModelsToDtos(appUser.getTasks());

        return new AppUserDTOResponse(appUser.getUserCode(), appUser.getFirstName(), appUser.getLastName(), appUser.getEmail(), appUser.isAdmin(), projectDTOList, taskDTOList, appUser.getCreatedAt());
    }
}
