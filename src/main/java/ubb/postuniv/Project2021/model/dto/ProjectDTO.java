package ubb.postuniv.Project2021.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details about the project")
public class ProjectDTO extends BaseDTO {

    @ApiModelProperty(notes = "The unique code of the project")
    private String projectCode;

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;
    private ProjectStatus projectStatus;

    @ApiModelProperty(notes = "The unique code of the user that added the project")
    private String addedByUserCode;

    private List<TaskDTO> tasks = new ArrayList<>();
}
