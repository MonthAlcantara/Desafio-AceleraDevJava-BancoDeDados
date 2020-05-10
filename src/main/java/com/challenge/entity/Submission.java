package com.challenge.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Submission {

    @Column(name = "user_id")
    @ManyToOne
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "chalenge_id")
    private Long chalengeId;

    @Column(nullable = false)
    private Float score;

    private LocalDate dataCriacao;

    @ManyToOne()
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;
}
