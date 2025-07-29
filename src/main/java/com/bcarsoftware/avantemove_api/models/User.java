package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "first_name")
    private String firstName;
    @JoinColumn(name = "last_name")
    private String lastName;
    @JoinColumn(name = "birth_date")
    private Date birthDate;

    private String gender; // TODO: EnumGender
    private String username;
    private String email;
    private String password;
    private String mobile;
    private int experience = 10;
    private boolean active;

    @OneToMany(mappedBy = "goals", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals;

    @OneToMany(mappedBy = "habits", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habit> habits;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;

    @OneToMany(mappedBy = "principles", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Belief> beliefs;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {this.createdAt = Instant.now(); this.updatedAt = Instant.now();}

    @PreUpdate
    protected void onUpdate() {this.updatedAt = Instant.now();}
}
