package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ubb.postuniv.Project2021.model.pojo.Role;

import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Details about the user")
public class AppUserDTOResponse extends BaseDTO {

    @ApiModelProperty(notes = "The unique code of the user")
    private String userCode;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private boolean isAdmin;
    private Set<Role> roles = new HashSet<>();
    private List<ProjectDTOResponse> projects = new ArrayList<>();
    private List<TaskDTOResponse> tasks = new ArrayList<>();
    private Date createdAt;

}
