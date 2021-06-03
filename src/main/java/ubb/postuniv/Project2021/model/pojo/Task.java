package ubb.postuniv.Project2021.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity<Long> {

    @Column(unique = true)
    private String taskCode;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateAdded;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private String assignedToUserCode;

    @ManyToOne
    private Project project;

    @ManyToOne
    AppUser createdBy;

    @ManyToOne
    AppUser assignedTo;

    @PrePersist
    private void onCreate() {

        dateAdded = new Date();
    }


    public Task(String title, String description, Date dateAdded, LocalDate deadline, TaskStatus taskStatus) {
        this.taskCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
    }

    public Task(String title, String description, Date dateAdded, LocalDate deadline, TaskStatus taskStatus, String assignedToUserCode) {
        this.taskCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.assignedToUserCode = assignedToUserCode;
    }

    public Task(String title, String description, LocalDate deadline, TaskStatus taskStatus, String assignedToUserCode) {
        this.taskCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.assignedToUserCode = assignedToUserCode;
    }
}
