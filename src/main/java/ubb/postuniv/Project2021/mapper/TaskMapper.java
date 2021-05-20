package ubb.postuniv.Project2021.mapper;

import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.model.dto.TaskDTO;
import ubb.postuniv.Project2021.model.enums.TaskStatus;
import ubb.postuniv.Project2021.model.pojo.Task;

@Component
public class TaskMapper extends AbstractMapper<Task, TaskDTO> {

    @Override
    public Task convertDtoToModel(TaskDTO taskDTO) {

        return new Task(taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDateAdded(), taskDTO.getDeadline(), TaskStatus.valueOf(taskDTO.getTaskStatus().toUpperCase()), taskDTO.getCreatedByUserCode(), taskDTO.getAssignedToUserCode());
    }

    @Override
    public TaskDTO convertModelToDto(Task task) {

        return new TaskDTO(task.getTitle(), task.getDescription(), task.getDateAdded(), task.getDeadline(), task.getTaskStatus().getTaskStatus(), task.getCreatedByUserCode(), task.getAssignedToUserCode());
    }
}
