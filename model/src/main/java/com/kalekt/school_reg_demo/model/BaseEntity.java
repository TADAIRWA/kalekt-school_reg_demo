package com.kalekt.school_reg_demo.model;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
public class BaseEntity implements Serializable {
    @Embedded
    private final Audit audit = new Audit();
    private Boolean active = true;
    @Id
    @GeneratedValue(generator = "id_generator")
    @TableGenerator(name = "id_generator", pkColumnName = "id_name",
            allocationSize = 50, initialValue = 1, valueColumnName = "id_value", table = "id_generators")
    private Long id;
    @Version
    private Long version;
    private Boolean deleted = false;

    public BaseEntity() {
    }

    public BaseEntity(Long id, Long version, Boolean deleted, Boolean active) {
        this.id = id;
        this.version = version;
        this.deleted = deleted;
        this.active = active;
    }

    public void pseudoDelete() {
        this.deleted = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Audit getAudit() {
        return audit;
    }

}
