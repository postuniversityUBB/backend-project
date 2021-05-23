package ubb.postuniv.Project2021.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class    Task extends BaseEntity<Long> {

    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private String createdByUserCode;
    private String assignedToUserCode;

    @ManyToOne
    private Project project;

    @ManyToOne
    AppUser createdBy;

    @ManyToOne
    AppUser assignedTo;

    public Task(String title, String description, LocalDate dateAdded, LocalDate deadline, TaskStatus taskStatus, String createdByUserCode, String assignedToUserCode) {
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.createdByUserCode = createdByUserCode;
        this.assignedToUserCode = assignedToUserCode;
    }

    public Task(String title, String description, LocalDate dateAdded, LocalDate deadline, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
    }
}
