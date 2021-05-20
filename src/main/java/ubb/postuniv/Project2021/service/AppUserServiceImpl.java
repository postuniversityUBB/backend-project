package ubb.postuniv.Project2021.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.repository.AppUserRepository;

import java.util.List;


@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAll() {

        return appUserRepository.findAll();
    }

    @Override
    public void addUSer(AppUser appUser) {

        appUserRepository.save(appUser);
    }
}
