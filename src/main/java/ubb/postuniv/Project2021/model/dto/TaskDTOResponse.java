package ubb.postuniv.Project2021.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Details about the task")
public class TaskDTOResponse extends BaseDTO {

    @ApiModelProperty(notes = "The unique code of the task")
    private String taskCode;

    private String title;
    private String description;
    private Date dateAdded;
    private LocalDate deadline;
    private String taskStatus;
    private String createdBy;
    private String assignedTo;
}
