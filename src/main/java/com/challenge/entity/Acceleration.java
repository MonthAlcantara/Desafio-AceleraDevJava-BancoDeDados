package com.challenge.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Acceleration {

    @Id
    @OneToMany
    private Long id;

    @Column(name = "name", length = 100)
    private String nome;

    @Column(length = 50)
    private String slug;

    @OneToMany
    @JoinColumn(name = "challenge_id")
    private Long challengeId;

    @Column(name = "created_at")
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "id.user")
    List<Candidate> candidates;

    @OneToMany(mappedBy = "id.challenge")
    List<Challenge> challenges;
}
