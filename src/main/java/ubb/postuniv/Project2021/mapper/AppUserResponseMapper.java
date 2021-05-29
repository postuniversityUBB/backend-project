package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.AppUserDTOResponse;
import ubb.postuniv.Project2021.model.dto.ProjectDTOResponse;
import ubb.postuniv.Project2021.model.dto.TaskDTOResponse;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;


@Component
public class AppUserResponseMapper extends AbstractMapper<AppUser, AppUserDTOResponse> {


    @Autowired
    Mapper<Project, ProjectDTOResponse> projectMapper;

    @Autowired
    Mapper<Task, TaskDTOResponse> taskMapper;

    @Override
    public AppUser convertDtoToModel(AppUserDTOResponse appUserDTOResponse) {

        List<Project> projectList = projectMapper.convertDtosToModels(appUserDTOResponse.getProjects());
        List<Task> taskList = taskMapper.convertDtosToModels(appUserDTOResponse.getTasks());

        return new AppUser(appUserDTOResponse.getUserCode(),
                appUserDTOResponse.getFirstName(),
                appUserDTOResponse.getLastName(),
                appUserDTOResponse.getUsername(),
                appUserDTOResponse.getEmail(),
                appUserDTOResponse.isAdmin(),
                projectList, taskList,
                appUserDTOResponse.getCreatedAt());
    }

    @Override
    public AppUserDTOResponse convertModelToDto(AppUser appUser) {

        List<ProjectDTOResponse> projectDTORequestList = projectMapper.convertModelsToDtos(appUser.getProjects());
        List<TaskDTOResponse> taskDTORequestList = taskMapper.convertModelsToDtos(appUser.getTasks());

        return new AppUserDTOResponse(appUser.getUserCode(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getUsername(),
                appUser.getEmail(),
                appUser.isAdmin(),
                appUser.getRoles(),
                projectDTORequestList,
                taskDTORequestList,
                appUser.getCreatedAt());
    }
}
