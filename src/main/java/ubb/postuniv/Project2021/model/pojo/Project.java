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
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Project.class)
public class Project extends BaseEntity<Long> {

    @Column(unique = true)
    private String projectCode;
    private String title;
    private String description;
    private LocalDate dateAdded;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    private String addedByUserCode;

    @ManyToOne
    AppUser appUser;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();


    public Project(String projectCode, String title, String description, LocalDate dateAdded, LocalDate deadline, ProjectStatus projectStatus, String addedByUserCode, List<Task> taskList) {

        this.projectCode = projectCode;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;
        this.addedByUserCode = addedByUserCode;
        this.tasks = tasks;
    }

    public Project(String projectCode, String title, String description, LocalDate dateAdded, LocalDate deadline, ProjectStatus projectStatus, List<Task> tasks) {
        this.projectCode = projectCode;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.deadline = deadline;
        this.projectStatus = projectStatus;
        this.tasks = tasks;
    }
}
