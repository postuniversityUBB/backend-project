package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Details about the task")
public class TaskDTORequest extends BaseDTO {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;
    private String taskStatus;

    @ApiModelProperty(notes = "The unique code of the user that added the task")
    private String createdByUserCode;

    @ApiModelProperty(notes = "The unique code of the user that the task was assigned to")
    private String assignedToUserCode;

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateAdded=" + dateAdded +
                ", deadline=" + deadline +
                ", taskStatus=" + taskStatus +
                ", createdByUserCode='" + createdByUserCode + '\'' +
                ", assignedToUserCode='" + assignedToUserCode + '\'';
    }
}
