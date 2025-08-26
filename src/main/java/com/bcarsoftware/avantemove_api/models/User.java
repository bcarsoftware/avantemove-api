package com.bcarsoftware.avantemove_api.models;

import com.bcarsoftware.avantemove_api.enums.EnumGender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 34)
    private String firstName;
    @Column(name = "last_name", length = 256)
    private String lastName;
    @JoinColumn(name = "birth_date")
    private LocalDate birthDate;

    private EnumGender gender;

    @Column(unique = true, length = 256)
    private String username;
    @Column(unique = true, length = 258)
    private String email;

    private String password;

    @Column(length = 20)
    private String mobile;
    private int experience = 10;
    private boolean active;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habit> habits;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Belief> beliefs;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Recovery recovery;

    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {this.createdAt = Instant.now(); this.updatedAt = Instant.now();}

    @PreUpdate
    protected void onUpdate() {this.updatedAt = Instant.now();}
}
