package com.kalekt.school_reg_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "class_level", uniqueConstraints = {@UniqueConstraint(name = "ux_class_level", columnNames = {"class_id", "level_id"})})
public class ClassLevel extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class aClass;
    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;
}
