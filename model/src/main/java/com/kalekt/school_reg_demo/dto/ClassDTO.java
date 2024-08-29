package com.kalekt.school_reg_demo.dto;

import jakarta.validation.constraints.NotEmpty;

public class ClassDTO {
    @NotEmpty
    private String name;

}
