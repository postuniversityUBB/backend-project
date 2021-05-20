package ubb.postuniv.Project2021.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProjectException extends RuntimeException {

    public ProjectException(String message) {

        super(message);
    }
}
