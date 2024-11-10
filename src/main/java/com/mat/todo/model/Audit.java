package com.mat.todo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable
public class Audit {

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
