package com.challenge.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String nomeCompleto;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(name= "nickName", nullable = false, length = 50)
    private String apelido;

    @Column(name = "password", nullable = false)
    private String senha;

    @Column(name = "created_at", nullable = false)
    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;


}
