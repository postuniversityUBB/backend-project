package ubb.postuniv.Project2021.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO extends BaseDTO {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;
    private TaskStatus taskStatus;
    private String createdByUserCode;
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
