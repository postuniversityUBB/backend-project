package ubb.postuniv.Project2021.service;

import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;


public interface ProjectService {

    List<Project> getAll();

    void addProject(Project project);

    void addTaskToProject(String projectCode, Task task);


}
