package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass  // ← テーブルは作らず、継承先に引き継ぐ
public abstract class BaseEntity {

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // getter / setter
}
