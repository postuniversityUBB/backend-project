package ubb.postuniv.Project2021.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO extends BaseDTO {

    private String projectCode;
    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;
    private ProjectStatus projectStatus;
    private String addedByUserCode;
    private List<TaskDTO> tasks = new ArrayList<>();
}
