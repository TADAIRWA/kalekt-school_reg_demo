package com.kalekt.school_reg_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class Audit implements Serializable {
    @Column(
            name = "created_date",
            nullable = false,
            updatable = false
    )
    @CreatedDate
    private Date createdDate;
    @Column(
            name = "modified_date"
    )
    @LastModifiedDate
    private Date modifiedDate;
    @Column(
            name = "created_by"
    )
    @CreatedBy
    private String createdBy;
    @Column(
            name = "modified_by"
    )
    @LastModifiedBy
    private String modifiedBy;

    public Audit() {
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    protected void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    protected void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    protected void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    protected void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String toString() {
        return "Audit{createdDate=" + this.createdDate + ", modifiedDate=" + this.modifiedDate + ", createdBy='" + this.createdBy + '\'' + ", modifiedBy='" + this.modifiedBy + '\'' + '}';
    }
}