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

        return new AppUser(appUserDTORequest.getUserCode(),
                appUserDTORequest.getFirstName(),
                appUserDTORequest.getLastName(),
                appUserDTORequest.getUsername(),
                appUserDTORequest.getEmail(),
                appUserDTORequest.getPassword(),
                appUserDTORequest.isAdmin(),
                appUserDTORequest.getRoles());
    }

    @Override
    public AppUserDTORequest convertModelToDto(AppUser appUser) {

        return new AppUserDTORequest(appUser.getUserCode(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getUsername(),
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.isAdmin(),
                appUser.getRoles());

    }
}
