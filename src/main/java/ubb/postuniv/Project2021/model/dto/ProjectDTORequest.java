package ubb.postuniv.Project2021.model.dto;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Details about the project")
public class ProjectDTORequest extends BaseDTO {

    private String title;
    private String description;
    private LocalDate deadline;
    private String projectStatus;

}
