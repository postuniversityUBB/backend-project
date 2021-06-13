package ubb.postuniv.Project2021.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ubb.postuniv.Project2021.model.pojo.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService extends UserDetailsService {

    List<AppUser> getAll();

    AppUser getUser(String userCode);

    void addUser(AppUser appUser);

    void deleteUser(String userCode);

    void updateUser(AppUser user, String userCode);
}
