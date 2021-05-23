package ubb.postuniv.Project2021.model.validator;

import org.springframework.stereotype.Component;
import ubb.postuniv.Project2021.exception.ProjectException;
import ubb.postuniv.Project2021.model.enums.ProjectStatus;

import java.util.Arrays;

@Component
public class ProjectCategoryValidator implements Validator<String> {

    @Override
    public void validate(String category) {

        boolean anyMatch = Arrays.stream(ProjectStatus.values())
                .anyMatch(category1 -> category1.toString().equalsIgnoreCase(category.toUpperCase()));

        if (!anyMatch) {

            throw new ProjectException("The category you entered is not valid. Please enter: e.g. dev, alpha, beta, production");
        }
    }
}