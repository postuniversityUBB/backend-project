package ubb.postuniv.Project2021.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details about the user")
public class AppUserDTORequest extends BaseDTO {

    @ApiModelProperty(notes = "The unique code of the user")
    private String userCode;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
    private List<ProjectDTORequest> projects = new ArrayList<>();
    private List<TaskDTORequest> tasks = new ArrayList<>();


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
