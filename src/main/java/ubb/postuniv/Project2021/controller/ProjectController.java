package ubb.postuniv.Project2021.controller;


import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.postuniv.Project2021.mapper.Mapper;
import ubb.postuniv.Project2021.model.dto.ProjectDTO;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
@CrossOrigin(origins = "*")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @Autowired
    Mapper<Project, ProjectDTO> projectMapper;

    @Autowired
    Mapper<Task, TaskDTO> taskMapper;


    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> showAllProjects() {

        log.info("projectList = {}", projectService.getAll());

        return new ResponseEntity<>(projectMapper.convertModelsToDtos(projectService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/projects")
    public void addProject(@RequestBody ProjectDTO projectDto) {

        log.info("projectDto = {}", projectDto);

        projectService.addProject(projectMapper.convertDtoToModel(projectDto));
    }

    @PostMapping("projects/{projectCode}/tasks")
    public void addTaskToProject(@ApiParam(value = "The project code for which you want to add a task", required = true) @PathVariable String projectCode, @RequestBody TaskDTO taskDto) {

        log.info("projectCode = {}, TaskDto = {}", projectCode, taskDto);

        projectService.addTaskToProject(projectCode, taskMapper.convertDtoToModel(taskDto));
    }


}
