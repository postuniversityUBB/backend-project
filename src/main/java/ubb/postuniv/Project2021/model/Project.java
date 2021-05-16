package ubb.postuniv.Project2021.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project  extends Entity<Long> {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;
    private ProjectStatus projectStatus;
    private AppUser user;
    private List<Task> tasks;


}
