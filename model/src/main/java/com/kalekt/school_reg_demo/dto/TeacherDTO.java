package com.kalekt.school_reg_demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDTO extends UserDTO {
    private String teacherID;
}
