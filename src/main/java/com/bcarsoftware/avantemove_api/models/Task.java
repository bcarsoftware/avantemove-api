package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Habit habit;

    private String comment;
    private boolean finished;

    @JoinColumn(name = "created_at")
    private Calendar createdAt;
    @JoinColumn(name = "updated_at")
    private Calendar updatedAt;
}
