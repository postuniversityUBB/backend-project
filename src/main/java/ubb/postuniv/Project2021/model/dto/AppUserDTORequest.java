package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ubb.postuniv.Project2021.model.pojo.Role;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Details about the user")
public class AppUserDTORequest {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();



}
