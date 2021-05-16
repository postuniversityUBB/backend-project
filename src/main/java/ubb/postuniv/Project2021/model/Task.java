package ubb.postuniv.Project2021.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task extends Entity<Long> {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private AppUser createdBy;
    private AppUser assignedTo;
    private LocalDate deadline;
    private TaskStatus taskStatus;

}
