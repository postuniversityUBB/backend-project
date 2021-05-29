package ubb.postuniv.Project2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ubb.postuniv.Project2021.model.pojo.Project;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByProjectCode(String projectCode);

}
