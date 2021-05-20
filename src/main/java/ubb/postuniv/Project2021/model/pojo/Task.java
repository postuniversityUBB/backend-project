package ubb.postuniv.Project2021.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity<Long> {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private String createdByUserCode;
    private String assignedToUserCode;

}
