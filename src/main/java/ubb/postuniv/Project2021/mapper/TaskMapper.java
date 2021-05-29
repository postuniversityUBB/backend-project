package ubb.postuniv.Project2021.mapper;

import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.TaskDTORequest;
import ubb.postuniv.Project2021.model.enums.TaskStatus;
import ubb.postuniv.Project2021.model.pojo.Task;

@Component
public class TaskMapper extends AbstractMapper<Task, TaskDTORequest> {

    @Override
    public Task convertDtoToModel(TaskDTORequest taskDTORequest) {

        return new Task(taskDTORequest.getTitle(),
                taskDTORequest.getDescription(),
                taskDTORequest.getDateAdded(),
                taskDTORequest.getDeadline(),
                TaskStatus.valueOf(taskDTORequest.getTaskStatus().toUpperCase()),
                taskDTORequest.getAssignedToUserCode());
    }

    @Override
    public TaskDTORequest convertModelToDto(Task task) {

        return new TaskDTORequest(task.getTitle(),
                task.getDescription(),
                task.getDateAdded(),
                task.getDeadline(),
                task.getTaskStatus().getTaskStatus(),
                task.getAssignedToUserCode());
    }
}
