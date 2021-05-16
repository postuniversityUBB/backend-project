package ubb.postuniv.Project2021.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @GetMapping("/")
    public String hello() {

        return "hello world!";
    }
}
