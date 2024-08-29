package com.kalekt.school_reg_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Teacher extends UserData {
    @Column(name = "teacher_id", unique = true)
    private String teacherID;

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
