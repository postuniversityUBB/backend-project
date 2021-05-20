package ubb.postuniv.Project2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ubb.postuniv.Project2021.model.pojo.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByUserCode(String userCode);

}
