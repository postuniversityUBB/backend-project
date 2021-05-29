package ubb.postuniv.Project2021.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.model.pojo.AppUser;
import ubb.postuniv.Project2021.repository.AppUserRepository;
import ubb.postuniv.Project2021.security.model.SecurityUser;

import java.util.List;
import java.util.Optional;


@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<AppUser> getAll() {

        return appUserRepository.findAll();
    }

    @Override
    public void addUser(AppUser appUser) {

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        appUserRepository.save(appUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(username);

        if (!optionalAppUser.isPresent()) {

            throw new UsernameNotFoundException("Could not find user");
        }

        return new SecurityUser(optionalAppUser.get());
    }
}
