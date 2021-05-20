package ubb.postuniv.Project2021.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.AppUserDTO;
import ubb.postuniv.Project2021.model.dto.ProjectDTO;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

@Component
public class AppUserMapper extends AbstractMapper<AppUser, AppUserDTO> {


    @Autowired
    Mapper<Project, ProjectDTO> projectMapper;

    @Autowired
    Mapper<Task, TaskDTO> taskMapper;


    @Override
    public AppUser convertDtoToModel(AppUserDTO appUserDTO) {

        List<Project> projectList = projectMapper.convertDtosToModels(appUserDTO.getProjects());
        List<Task> taskList = taskMapper.convertDtosToModels(appUserDTO.getTasks());

        return new AppUser(appUserDTO.getUserCode(), appUserDTO.getFirstName(), appUserDTO.getLastName(), appUserDTO.getEmail(), appUserDTO.getPassword(), appUserDTO.isAdmin(), projectList, taskList);
    }

    @Override
    public AppUserDTO convertModelToDto(AppUser appUser) {

        List<ProjectDTO> projectDTOList = projectMapper.convertModelsToDtos(appUser.getProjects());
        List<TaskDTO> taskDTOList = taskMapper.convertModelsToDtos(appUser.getTasks());

        return new AppUserDTO(appUser.getUserCode(), appUser.getFirstName(), appUser.getLastName(), appUser.getEmail(), appUser.getPassword(), appUser.isAdmin(), projectDTOList, taskDTOList);
    }
}
