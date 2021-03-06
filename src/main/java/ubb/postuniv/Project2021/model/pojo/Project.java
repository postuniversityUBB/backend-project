package ubb.postuniv.Project2021.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project extends BaseEntity<Long> {

    @Column(unique = true)
    private String projectCode;

    private String title;
    private String description;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @ManyToOne
    AppUser appUser;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public Project(String title, String description, Date dateAdded, LocalDate deadline, ProjectStatus projectStatus, List<Task> tasks) {
        this.projectCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;
        this.tasks = tasks;
    }

    public Project(String title, String description, Date dateAdded, LocalDate deadline, ProjectStatus projectStatus) {
        this.projectCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;

    }

    public Project(String title, String description, LocalDate deadline, ProjectStatus projectStatus) {
        this.projectCode = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.projectStatus = projectStatus;

    }
}
