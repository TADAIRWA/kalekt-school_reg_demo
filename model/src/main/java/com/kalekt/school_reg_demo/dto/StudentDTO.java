package com.kalekt.school_reg_demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO extends UserDTO {
    private String studentID;
    @NotNull(message = "Student level is mandatory")
    private long levelID;
    @NotEmpty(message = "Student level is mandatory")
    private String levelName;
}
