package ubb.postuniv.Project2021.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ubb.postuniv.Project2021.model.pojo.AppUser;

import java.util.List;

public interface AppUserService extends UserDetailsService {

    List<AppUser> getAll();

    void addUser(AppUser appUser);

    void deleteUser(String userCode);
}
