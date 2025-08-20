package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "recovery")
public class Recovery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "first_question", nullable = false)
    private String firstQuestion;

    @Column(name = "second_question", nullable = false)
    private String secondQuestion;

    @Column(name = "third_question", nullable = false)
    private String thirdQuestion;

    @Column(name = "first_response", nullable = false)
    private String firstResponse;

    @Column(name = "second_response", nullable = false)
    private String secondResponse;

    @Column(name = "third_response", nullable = false)
    private String thirdResponse;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {this.createdAt = Instant.now(); this.updatedAt = Instant.now();}

    @PreUpdate
    protected void onUpdate() {this.updatedAt = Instant.now();}
}
