package ubb.postuniv.Project2021.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.postuniv.Project2021.mapper.Mapper;
import ubb.postuniv.Project2021.model.dto.AppUserDTORequest;
import ubb.postuniv.Project2021.model.dto.AppUserDTOResponse;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.service.AppUserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
@CrossOrigin(origins = "*")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private Mapper<AppUser, AppUserDTORequest> appUserMapper;

    @Autowired
    private Mapper<AppUser, AppUserDTOResponse> appUserResponseMapper;


    @GetMapping("/users")
    public ResponseEntity<List<AppUserDTOResponse>> showAllUsers() {

        log.info("appUserList = {}", appUserService.getAll());

        return new ResponseEntity<>(appUserResponseMapper.convertModelsToDtos(appUserService.getAll()), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userCode}")
    public void removeUser(@PathVariable String userCode) {

        log.info("userCode = {}", userCode);
        appUserService.deleteUser(userCode);
    }


    @PostMapping(path = "/users/register")
    public void addUser(@RequestBody AppUserDTORequest appUserDtoRequest) {

        log.info("appUserDto = {}", appUserDtoRequest);

        appUserService.addUser(appUserMapper.convertDtoToModel(appUserDtoRequest));
    }

    @PutMapping("/users/update/{userCode}")
    public void updateUser(@RequestBody AppUserDTORequest appUserDTORequest, @PathVariable String userCode) {

        log.info("appUserDto = {}", appUserDTORequest);

        appUserService.updateUser(appUserMapper.convertDtoToModel(appUserDTORequest), userCode);
    }

    @GetMapping("/users/{userCode}")
    public ResponseEntity<AppUserDTOResponse> getUser(@PathVariable String userCode) {

        log.info("userCode = {}", userCode);

        return new ResponseEntity<>(appUserResponseMapper.convertModelToDto(appUserService.getUser(userCode)), HttpStatus.OK);
    }
}
