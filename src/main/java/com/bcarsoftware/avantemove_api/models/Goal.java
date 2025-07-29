package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private String description;

    @JoinColumn(name = "start_date")
    private Date startDate;
    @JoinColumn(name = "finish_date")
    private Date finishDate;

    private boolean active;

    @JoinColumn(name = "created_at")
    private Calendar createdAt;
    @JoinColumn(name = "updated_at")
    private Calendar updatedAt;
}
