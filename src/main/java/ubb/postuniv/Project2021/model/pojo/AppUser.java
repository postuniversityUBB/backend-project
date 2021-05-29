package ubb.postuniv.Project2021.model.pojo;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Project.class)
public class AppUser extends BaseEntity<Long> {

    @Column(unique = true)
    private String userCode;

    private String firstName;
    private String lastName;

    private String username;
    private String email;
    private String password;
    private boolean isAdmin;

    @OneToMany(mappedBy = "appUser")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "assignedTo")
    private List<Task> tasks = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;


    @PrePersist
    private void onCreate() {

        createdAt = new Date();
    }

    public AppUser(String userCode, String username, String password, Set<Role> roles) {
        this.userCode = userCode;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public AppUser(String userCode, String firstName, String lastName, String username, String email, String password, boolean isAdmin, Set<Role> roles) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.roles = roles;
    }

    public AppUser(String userCode, String firstName, String lastName, String username, String email, boolean isAdmin, List<Project> projects, List<Task> tasks, Date createdAt) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
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
