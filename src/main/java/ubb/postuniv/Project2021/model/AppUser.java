package ubb.postuniv.Project2021.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser extends Entity<Long> {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
    private List<Project> projects;
    private List<Task> tasks;  //?

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false)
    private Date timestamp;

    //@PrePersist
    private void onCreate() {

        timestamp = new Date();
    }
}
