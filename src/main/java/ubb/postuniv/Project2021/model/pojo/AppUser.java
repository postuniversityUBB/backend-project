package ubb.postuniv.Project2021.model.pojo;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Project.class)
public class AppUser extends BaseEntity<Long> {

    @Column(unique = true)
    private String userCode;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;

    @OneToMany(mappedBy = "appUser")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasks = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    public AppUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AppUser(String userCode, String firstName, String lastName, String email, boolean isAdmin, List<Project> projects, List<Task> tasks, Date createdAt) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = isAdmin;
        this.projects = projects;
        this.tasks = tasks;
        this.createdAt = createdAt;
    }

    public AppUser(String userCode, String firstName, String lastName, String email, String password, boolean isAdmin, List<Project> projects, List<Task> tasks) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.projects = projects;
        this.tasks = tasks;
    }

    @PrePersist
    private void onCreate() {

        createdAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(firstName, appUser.firstName) && Objects.equals(lastName, appUser.lastName) && Objects.equals(email, appUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}
