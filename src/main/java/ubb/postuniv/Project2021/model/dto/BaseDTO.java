package ubb.postuniv.Project2021.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @Override
    public String toString() {
        return "id=" + id;
    }
}
