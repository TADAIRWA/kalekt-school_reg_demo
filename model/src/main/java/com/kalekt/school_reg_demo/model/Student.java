package com.kalekt.school_reg_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends UserData {
    @Column(name = "student_id", unique = true)
    private String studentID;

    @ManyToOne
    @JoinColumn(name = "level_id"
    )
    private Level level;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
