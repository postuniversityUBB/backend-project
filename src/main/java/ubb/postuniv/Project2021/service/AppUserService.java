package ubb.postuniv.Project2021.service;

import ubb.postuniv.Project2021.model.pojo.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> getAll();

    void addUSer(AppUser appUser);
}
