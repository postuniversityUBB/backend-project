package ubb.postuniv.Project2021.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ItemNotFoundException;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.repository.ProjectRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<Project> getAll() {

        return projectRepository.findAll();
    }

    @Override
    public Project getOneProject(UUID projectCode) {

        return projectRepository.findByProjectCode(projectCode).orElseThrow(() ->
                new ItemNotFoundException("The project with code " + projectCode + " does not exist"));
    }

    @Override
    public void addProject(Project project) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow();

        project.setAppUser(appUser);

        projectRepository.save(project);

        appUser.getProjects().add(project);
        appUserRepository.save(appUser);

    }

    @Override
    public void addTaskToProject(UUID projectCode, Task task) {

        Project project = projectRepository.findByProjectCode(projectCode).orElseThrow(() ->
                new ItemNotFoundException("Project with code " + projectCode + " was not found"));

        project.getTasks().add(task);
        task.setProject(project);

        AppUser createdByUser = appUserRepository.findByUserCode(task.getCreatedByUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getCreatedByUserCode() + " was not found"));

        AppUser assignedToUser = appUserRepository.findByUserCode(task.getAssignedToUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getCreatedByUserCode() + " was not found"));

        task.setCreatedBy(createdByUser);
        task.setAssignedTo(assignedToUser);

        projectRepository.save(project);
    }
}
