package ubb.postuniv.Project2021.model.pojo;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "projects")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Project.class)
public class Project extends BaseEntity<Long> {

    @Column(unique = true)
    private UUID projectCode;

    private String title;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateAdded;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @ManyToOne
    AppUser appUser;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();


    @PrePersist
    private void onCreate() {

        dateAdded = new Date();
    }


    public Project(String title, String description, Date dateAdded, LocalDate deadline, ProjectStatus projectStatus, List<Task> tasks) {
        this.projectCode = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;
        this.tasks = tasks;
    }

    public Project(String title, String description, Date dateAdded, LocalDate deadline, ProjectStatus projectStatus) {
        this.projectCode = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;

    }

    public Project(String title, String description, LocalDate deadline, ProjectStatus projectStatus) {
        this.projectCode = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.projectStatus = projectStatus;

    }
}
