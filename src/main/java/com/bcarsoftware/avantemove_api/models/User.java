package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
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
    private int experience;
    private boolean active;

    @OneToMany(mappedBy = "goals", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals;

    @JoinColumn(name = "created_at")
    private Calendar createdAt;
    @JoinColumn(name = "updated_at")
    private Calendar updatedAt;
}
