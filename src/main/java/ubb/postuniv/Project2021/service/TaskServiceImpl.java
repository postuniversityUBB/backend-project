package ubb.postuniv.Project2021.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ItemNotFoundException;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public List<Task> getAll() {

        return taskRepository.findAll();
    }

    @Override
    public void addTask(Task task) {

        AppUser createdByUser = getAuthenticatedUser();

        AppUser assignedToUser = appUserRepository.findByUserCode(task.getAssignedToUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getAssignedToUserCode() + " was not found"));

        assignedToUser.getTasks().add(task);

        taskRepository.save(task);

        appUserRepository.save(assignedToUser);

    }

    @Override
    public void deleteTask(String taskCode) {

        Optional<Task> task = taskRepository.findByTaskCode(taskCode);

        if (!task.isPresent()) {

            throw new ItemNotFoundException("Task with code" + taskCode + " not found");

        } else {

            taskRepository.delete(task.get());
        }
    }

    @Override
    public void updateTask(Task task, String taskCode) {

        Optional<Task> taskFound = taskRepository.findByTaskCode(taskCode);

        if (!taskFound.isPresent()) {

            throw new ItemNotFoundException("Sorry, the task with code " + taskCode + " can't be found!");

        } else {

            taskFound.get().setTitle(task.getTitle());
            taskFound.get().setDescription(task.getDescription());
            taskFound.get().setAssignedToUserCode(task.getAssignedToUserCode());
            taskFound.get().setDeadline(task.getDeadline());
            taskFound.get().setTaskStatus(task.getTaskStatus());

            taskRepository.save(taskFound.get());

        }
    }

    private AppUser getAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new ItemNotFoundException("User with code " + username + " was not found"));

        return appUser;
    }

}
