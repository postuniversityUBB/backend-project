package ubb.postuniv.Project2021.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ItemNotFoundException;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

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
    public Project getOneProject(String projectCode) {

        return projectRepository.findByProjectCode(projectCode).orElseThrow(() ->
                new ItemNotFoundException("The project with code " + projectCode + " does not exist"));
    }

    @Override
    public void deleteProject(String projectCode) {

        Optional<Project> project = projectRepository.findByProjectCode(projectCode);

        if (!project.isPresent()) {

            throw new ItemNotFoundException("The project with code " + projectCode + " does not exist");

        } else {

            projectRepository.delete(project.get());
        }
    }

    @Override
    public void updateProject(Project project, String projectCode) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new ItemNotFoundException("The user " + username + " was not found. Please register."));

        project.setAppUser(appUser);

        Optional<Project> projectFound = projectRepository.findByProjectCode(projectCode);

        if (!projectFound.isPresent()) {

            throw new ItemNotFoundException("Project with the code" + projectCode + " not found");

        } else {

            projectFound.get().setId(project.getId());
            projectFound.get().setTitle(project.getTitle());
            projectFound.get().setDescription(project.getDescription());
            projectFound.get().setAppUser(appUser);
            projectFound.get().setDeadline(project.getDeadline());
            projectFound.get().setDateAdded(project.getDateAdded());
            projectFound.get().setProjectStatus(project.getProjectStatus());

            projectRepository.save(projectFound.get());
        }
    }

    @Override
    public void addProject(Project project) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new ItemNotFoundException("The user " + username + " was not found. Please register."));

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

        AppUser createdByUser = getAuthenticatedUser();

        AppUser assignedToUser = appUserRepository.findByUserCode(task.getAssignedToUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getAssignedToUserCode() + " was not found"));

        task.setCreatedBy(createdByUser);
        task.setAssignedTo(assignedToUser);

        projectRepository.save(project);
    }

    private AppUser getAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new ItemNotFoundException("User with username " + username + " was not found"));

        return appUser;
    }
}
