package com.challenge.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class Company {

    @Id
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String slug;

    @Column(name = "created_at")
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;
}
