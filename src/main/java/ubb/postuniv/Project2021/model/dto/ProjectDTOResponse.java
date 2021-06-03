package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Details about the project")
public class ProjectDTOResponse extends BaseDTO {

    @ApiModelProperty(notes = "The unique code of the project")
    private String projectCode;
    private String title;
    private String description;
    private Date dateAdded;
    private LocalDate deadline;
    private String projectStatus;
    private String createdBy;
    private List<TaskDTOResponse> tasks = new ArrayList<>();

}
