package ubb.postuniv.Project2021.model.validator;

import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.exception.ProjectException;
import ubb.postuniv.Project2021.model.enums.TaskStatus;

import java.util.Arrays;

@Component
public class TaskCategoryValidator implements Validator<String>{
    public TaskCategoryValidator() {
    }

    @Override
    public void validate(String categ) {

        boolean anyMatch = Arrays.stream(TaskStatus.values())
                .anyMatch(categ1 -> categ1.toString().equalsIgnoreCase(categ.toUpperCase()));

        if (!anyMatch) {

            throw new ProjectException("The category you entered is not valid. Please enter: e.g. dev_on_desk, " +
                    "dev_in_progress, testing, cancelled or completed");
        }

    }
}
