package com.kalekt.school_reg_demo.dto;

import jakarta.validation.constraints.NotEmpty;

public class LevelDTO {
    @NotEmpty
    private String name;

}
