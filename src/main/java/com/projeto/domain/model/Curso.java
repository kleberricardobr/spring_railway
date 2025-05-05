package com.projeto.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 500)
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas;

    @JsonIgnore
    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos;
}
