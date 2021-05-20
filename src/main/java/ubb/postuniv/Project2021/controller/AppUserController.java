package ubb.postuniv.Project2021.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.postuniv.Project2021.mapper.Mapper;
import ubb.postuniv.Project2021.model.dto.AppUserDTO;
import ubb.postuniv.Project2021.model.dto.AppUserDTOResponse;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.service.AppUserService;

import java.util.List;

@RestController
@Log4j2
@CrossOrigin(origins = "*")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private Mapper<AppUser, AppUserDTO> appUserMapper;

    @Autowired
    private Mapper<AppUser, AppUserDTOResponse> appUserResponseMapper;



    @GetMapping("/users")
    public ResponseEntity<List<AppUserDTOResponse>> showAllUsers() {

        log.info("appUserList = {}", appUserService.getAll());

        return new ResponseEntity<>(appUserResponseMapper.convertModelsToDtos(appUserService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody AppUserDTO appUserDto) {

        log.info("appUserDto = {}", appUserDto);

        appUserService.addUSer(appUserMapper.convertDtoToModel(appUserDto));
    }
}
