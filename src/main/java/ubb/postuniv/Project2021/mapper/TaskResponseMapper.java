package ubb.postuniv.Project2021.mapper;

import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.TaskDTOResponse;
import ubb.postuniv.Project2021.model.enums.TaskStatus;
import ubb.postuniv.Project2021.model.pojo.Task;


@Component
public class TaskResponseMapper extends AbstractMapper<Task, TaskDTOResponse> {

    @Override
    public Task convertDtoToModel(TaskDTOResponse taskDTOResponse) {

        return new Task(taskDTOResponse.getTitle(),
                taskDTOResponse.getDescription(),
                taskDTOResponse.getDateAdded(),
                taskDTOResponse.getDeadline(),
                TaskStatus.valueOf(taskDTOResponse.getTaskStatus().toUpperCase()));
    }

    @Override
    public TaskDTOResponse convertModelToDto(Task task) {

        String createdBy = task.getCreatedBy().getFirstName() + " " + task.getCreatedBy().getLastName();
        String assignedTo = task.getAssignedTo().getFirstName() + " " +  task.getAssignedTo().getLastName();

        return new TaskDTOResponse(task.getTaskCode(),
                task.getTitle(),
                task.getDescription(),
                task.getDateAdded(),
                task.getLastModified(),
                task.getDeadline(),
                task.getTaskStatus().getTaskStatus(),
                createdBy,
                assignedTo,
                task.getAssignedToUserCode());
    }
}
