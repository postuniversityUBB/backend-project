package ubb.postuniv.Project2021.controller;


import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.postuniv.Project2021.mapper.Mapper;
import ubb.postuniv.Project2021.model.dto.ProjectDTORequest;
import ubb.postuniv.Project2021.model.dto.ProjectDTOResponse;
import ubb.postuniv.Project2021.model.dto.TaskDTORequest;
import ubb.postuniv.Project2021.model.pojo.Project;
import ubb.postuniv.Project2021.model.pojo.Task;
import ubb.postuniv.Project2021.model.validator.Validator;
import ubb.postuniv.Project2021.service.ProjectService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Log4j2
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    Mapper<Project, ProjectDTORequest> projectMapper;

    @Autowired
    Mapper<Project, ProjectDTOResponse> projectResponseMapper;

    @Autowired
    Mapper<Task, TaskDTORequest> taskMapper;

    @Autowired
    @Qualifier("projectCategoryValidator")
    private Validator<String> categoryValidator;

    @Autowired
    @Qualifier("taskCategoryValidator")
    private Validator<String> taskCategoryValidator;


    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTOResponse>> showAllProjects() {

        log.info("projectList = {}", projectService.getAll());

        return new ResponseEntity<>(projectResponseMapper.convertModelsToDtos(projectService.getAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/projects/{projectCode}")
    public ResponseEntity<ProjectDTOResponse> showProject(@PathVariable String projectCode) {

        log.info("project = {}", projectService.getOneProject(projectCode));

        return new ResponseEntity<>(projectResponseMapper.convertModelToDto(projectService.getOneProject(projectCode)), HttpStatus.OK);
    }


    @PostMapping("/projects")
    public void addProject(@RequestBody ProjectDTORequest projectDtoRequest) {

        log.info("projectDto = {}", projectDtoRequest);

        categoryValidator.validate(projectDtoRequest.getProjectStatus());

        projectService.addProject(projectMapper.convertDtoToModel(projectDtoRequest));
    }

    @DeleteMapping("/projects/{projectCode}")
    public void removeProject(@PathVariable String projectCode){
        projectService.deleteProject(projectCode);
    }

    @PutMapping("/projects/{projectCode}")
    public void updateProject(@RequestBody ProjectDTORequest projectDtoRequest, @PathVariable String projectCode){

        log.info("projectDto = {}", projectDtoRequest);

        categoryValidator.validate(projectDtoRequest.getProjectStatus());

        projectService.updateProject(projectMapper.convertDtoToModel(projectDtoRequest), projectCode);
    }

    @PostMapping("projects/{projectCode}/tasks")
    public void addTaskToProject(@ApiParam(value = "The project code for which you want to add a task", required = true) @PathVariable String projectCode, @RequestBody TaskDTORequest taskDtoRequest) {

        log.info("projectCode = {}, TaskDto = {}", projectCode, taskDtoRequest);

        taskCategoryValidator.validate(taskDtoRequest.getTaskStatus());

        projectService.addTaskToProject(projectCode, taskMapper.convertDtoToModel(taskDtoRequest));
    }


}
