package ubb.postuniv.Project2021.service;

import ubb.postuniv.Project2021.model.pojo.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    void addTask(Task task);

    void deleteTask(Long taskId);

    //void addTaskToUser(String userCode, Task task);
}
