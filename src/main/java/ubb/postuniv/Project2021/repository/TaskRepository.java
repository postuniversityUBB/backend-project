package ubb.postuniv.Project2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ubb.postuniv.Project2021.model.pojo.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
