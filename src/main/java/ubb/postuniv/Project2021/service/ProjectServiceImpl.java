package ubb.postuniv.Project2021.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ItemNotFoundException;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.repository.ProjectRepository;

import java.util.List;

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
    public void addProject(Project project) {

        AppUser appUser = appUserRepository.findByUserCode(project.getAddedByUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + project.getAddedByUserCode() + " was not found"));

        project.setAppUser(appUser);

        projectRepository.save(project);

        appUser.getProjects().add(project);
        appUserRepository.save(appUser);

    }

    @Override
    public void addTaskToProject(String projectCode, Task task) {

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
