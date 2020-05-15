package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Você deve informar o Nome completo")
    @Size(max = 100, message = "Seu Nome completo deve ter no máximo 100 caracteres")
    @Column(name = "full_name", length = 100)
    private String fullname;

    @NotNull(message = "Você deve informar o email")
    @Email
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    @NotNull(message = "Você deve informar um Nickname")
    @Size(max = 50, message = "Seu Nickname deve ter no máximo 50 caracteres")
    @Column(length = 50)
    private String nickname;

    @NotNull(message = "Você deve informar uma Senha")
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;


}
