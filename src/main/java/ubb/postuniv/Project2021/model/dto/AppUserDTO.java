package ubb.postuniv.Project2021.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppUserDTO extends BaseDTO {

    private String userCode;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
    private List<ProjectDTO> projects = new ArrayList<>();
    private List<TaskDTO> tasks = new ArrayList<>();


    @Override
    public String toString() {
        return "userCode='" + userCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", projects=" + projects +
                ", tasks=" + tasks;

    }
}
