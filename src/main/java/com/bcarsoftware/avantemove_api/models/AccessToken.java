package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "access_token")
public class AccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 512)
    private String username;
    @Column(nullable = false, unique = true, length = 512)
    private String token;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {this.createdAt = Instant.now(); this.updatedAt = Instant.now();}

    @PreUpdate
    protected void onUpdate() {this.updatedAt = Instant.now();}
}
