package com.kalekt.school_reg_demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalekt.school_reg_demo.model.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "First name cannot be blank or null!")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank or null!")
    private String lastName;
    @NotNull(message = "Gender cannot be null!")
    private Gender gender;
    @Past(message = "Date Of birth can only be in the past!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    private boolean active;
    private boolean deleted;
}
