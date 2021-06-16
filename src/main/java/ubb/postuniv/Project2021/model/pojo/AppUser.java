package ubb.postuniv.Project2021.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class AppUser extends BaseEntity<Long> {

    @Column(unique = true)
    private String userCode;

    private String firstName;
    private String lastName;

    private String username;
    private String email;
    private String password;

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

    public AppUser(String userCode, String username, String password, Set<Role> roles) {
        this.userCode = userCode;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public AppUser(String userCode, String firstName, String lastName, String username, String email, String password, Set<Role> roles) {
        this(userCode, username, password,roles);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AppUser(String userCode, String firstName, String lastName, String username, String email, List<Project> projects, List<Task> tasks, Date createdAt) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.projects = projects;
        this.tasks = tasks;
        this.dateAdded = createdAt;
    }

    public AppUser(String userCode, String firstName, String lastName, String email, String password, List<Project> projects, List<Task> tasks) {
        this.userCode = userCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
