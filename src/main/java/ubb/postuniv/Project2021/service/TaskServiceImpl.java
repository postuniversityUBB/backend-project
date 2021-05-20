package ubb.postuniv.Project2021.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ItemNotFoundException;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.repository.TaskRepository;

import java.util.List;

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

        AppUser createdByUser = appUserRepository.findByUserCode(task.getCreatedByUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getCreatedByUserCode() + " was not found"));

        AppUser assignedToUser = appUserRepository.findByUserCode(task.getAssignedToUserCode()).orElseThrow(() ->
                new ItemNotFoundException("User with code " + task.getCreatedByUserCode() + " was not found"));

        assignedToUser.getTasks().add(task);

        taskRepository.save(task);

        appUserRepository.save(assignedToUser);

    }

}
