package com.projeto.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false, length = 500)
    private String nome;

    @Column(nullable = false, unique = true, name = "RA")
    private String RA;

    @ManyToMany
    @JoinTable(
            name = "curso_aluno",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos;
}
