package com.bcarsoftware.avantemove_api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "beliefs")
public class Belief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
