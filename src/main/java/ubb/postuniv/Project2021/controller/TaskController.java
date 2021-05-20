package ubb.postuniv.Project2021.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.postuniv.Project2021.mapper.Mapper;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    Mapper<Task, TaskDTO> taskMapper;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> showAllTasks() {

        log.info("taskList = {}", taskService.getAll());

        return new ResponseEntity<>(taskMapper.convertModelsToDtos(taskService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public void addOneTask(@RequestBody TaskDTO taskDto) {

        log.info("taskDto ={}", taskDto);

        taskService.addTask(taskMapper.convertDtoToModel(taskDto));
    }

}
