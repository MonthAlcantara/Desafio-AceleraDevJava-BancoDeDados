package com.challenge.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Candidate {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "acceleration_id", nullable = false)
    private Long accelerationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    private int status;

    @Column(name = "created_at")
    private LocalDate dataCriacao;
}
