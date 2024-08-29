package com.kalekt.school_reg_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Level extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
