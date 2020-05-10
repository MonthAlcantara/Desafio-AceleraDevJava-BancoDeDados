package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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

    @NotNull
    @Size(max = 100)
    @Column(name = "full_name", length = 100)
    private String fullname;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;


}
