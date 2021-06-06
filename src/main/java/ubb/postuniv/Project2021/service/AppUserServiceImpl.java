package ubb.postuniv.Project2021.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ubb.postuniv.Project2021.exception.ProjectException;
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

        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(appUser.getUsername());

        if(optionalAppUser.isPresent()) {

            throw new ProjectException("There is already an account registered with this username");
        }

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        appUserRepository.save(appUser);
    }

    @Override
    public void deleteUser(String userCode) {
        Optional<AppUser> user = appUserRepository.findByUserCode(userCode);

        if(!user.isPresent()){
            throw new UsernameNotFoundException("Could not find user");
        }else{
            appUserRepository.delete(user.get());
        }
    }

    @Override
        public void updateUser(AppUser user, String userCode) {
        Optional<AppUser> userFound = appUserRepository.findByUserCode(userCode);

        if(!userFound.isPresent()){
            throw new UsernameNotFoundException("Could not find user");
        }else{
            userFound.get().setUserCode(user.getUserCode());
            userFound.get().setFirstName(user.getFirstName());
            userFound.get().setLastName(user.getLastName());
            userFound.get().setUsername(user.getUsername());
            userFound.get().setEmail(user.getEmail());
            userFound.get().setPassword(user.getPassword());
            userFound.get().setAdmin(user.isAdmin());
            userFound.get().setRoles(user.getRoles());

            appUserRepository.save(userFound.get());
        }
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
