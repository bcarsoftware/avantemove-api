package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "habits")
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    private String name;
    private String category;
    
    @JoinColumn(name = "days_week")
    private List<Integer> daysWeek;

    private boolean active;

    @JoinColumn(name = "created_at")
    private Calendar createdAt;
    @JoinColumn(name = "updated_at")
    private Calendar updatedAt;
}
