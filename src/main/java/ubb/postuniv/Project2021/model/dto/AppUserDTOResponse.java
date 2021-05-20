package ubb.postuniv.Project2021.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    private String email;
    private boolean isAdmin;
    private List<ProjectDTO> projects = new ArrayList<>();
    private List<TaskDTO> tasks = new ArrayList<>();
    private Date createdAt;


}
