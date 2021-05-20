package ubb.postuniv.Project2021.model.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {

    DEV_ON_DESK("dev on desk"),
    DEV_IN_PROGRESS("dev in progress"),
    TESTING("testing"),
    CANCELLED("cancelled"),
    COMPLETED("completed");

    private String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
