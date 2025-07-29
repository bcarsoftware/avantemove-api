package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "habits")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    private String name;
    private String category;

    @Column(name = "days_week")
    private List<Integer> daysWeek;

    private boolean active;

    @OneToMany(mappedBy = "tasks",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {this.createdAt = Instant.now(); this.updatedAt = Instant.now();}

    @PreUpdate
    protected void onUpdate() {this.updatedAt = Instant.now();}
}
