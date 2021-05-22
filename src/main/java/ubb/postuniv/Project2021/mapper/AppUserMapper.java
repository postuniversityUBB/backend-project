package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.AppUserDTORequest;
import ubb.postuniv.Project2021.model.dto.ProjectDTORequest;
import ubb.postuniv.Project2021.model.dto.TaskDTORequest;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

@Component
public class AppUserMapper extends AbstractMapper<AppUser, AppUserDTORequest> {


    @Autowired
    Mapper<Project, ProjectDTORequest> projectMapper;

    @Autowired
    Mapper<Task, TaskDTORequest> taskMapper;


    @Override
    public AppUser convertDtoToModel(AppUserDTORequest appUserDTORequest) {

        List<Project> projectList = projectMapper.convertDtosToModels(appUserDTORequest.getProjects());
        List<Task> taskList = taskMapper.convertDtosToModels(appUserDTORequest.getTasks());

        return new AppUser(appUserDTORequest.getUserCode(), appUserDTORequest.getFirstName(), appUserDTORequest.getLastName(), appUserDTORequest.getEmail(), appUserDTORequest.getPassword(), appUserDTORequest.isAdmin(), projectList, taskList);
    }

    @Override
    public AppUserDTORequest convertModelToDto(AppUser appUser) {

        List<ProjectDTORequest> projectDTORequestList = projectMapper.convertModelsToDtos(appUser.getProjects());
        List<TaskDTORequest> taskDTORequestList = taskMapper.convertModelsToDtos(appUser.getTasks());

        return new AppUserDTORequest(appUser.getUserCode(), appUser.getFirstName(), appUser.getLastName(), appUser.getEmail(), appUser.getPassword(), appUser.isAdmin(), projectDTORequestList, taskDTORequestList);
    }
}
