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

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Você deve informar o nome da Aceleração")
    @Size(max = 100, message = "O nome da Aceleração deve ter no máximo 100 caracteres")
    @Column(length = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String slug;

    @ManyToOne
    private Challenge challenge;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.acceleration")
    private List<Candidate> candidates;

}
