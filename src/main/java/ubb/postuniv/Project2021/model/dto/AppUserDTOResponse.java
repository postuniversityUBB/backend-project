package ubb.postuniv.Project2021.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AppUserDTOResponse extends BaseDTO {

    private String userCode;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isAdmin;
    private List<ProjectDTO> projects = new ArrayList<>();
    private List<TaskDTO> tasks = new ArrayList<>();
    private Date createdAt;


}
