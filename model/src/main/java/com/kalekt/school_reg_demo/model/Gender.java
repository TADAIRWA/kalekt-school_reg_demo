package com.kalekt.school_reg_demo.model;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }
}
