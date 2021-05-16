package ubb.postuniv.Project2021.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ubb.postuniv.Project2021.model.Test;
import ubb.postuniv.Project2021.repository.TestRepository;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/")
    public String hello() {

        return "hello world!";
    }

    @GetMapping("/tests")
    public List<Test> tests() {

        return testRepository.findAll();
    }
}
