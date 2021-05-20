package ubb.postuniv.Project2021.model.enums;


import lombok.Getter;

@Getter
public enum ProjectStatus {

    DEV("dev"),
    ALPHA("alpha"),
    BETA("beta"),
    PRODUCTION("production");

    private String projectStatus;

    ProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
}
