package ubb.postuniv.Project2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ubb.postuniv.Project2021.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
