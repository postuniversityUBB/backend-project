package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ubb.postuniv.Project2021.model.pojo.Role;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Details about the user")
public class AppUserDTORequest {

    @ApiModelProperty(notes = "The unique code of the user")
    private String userCode;

    private String firstName;
    private String lastName;

    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "AppUserDTORequest{" +
                "userCode='" + userCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles;
    }
}
