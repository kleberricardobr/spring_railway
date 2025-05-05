package com.projeto.domain.repository;

import com.projeto.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    public Optional<Curso> findByNome(String nome);
    public Optional<Curso> findByNomeIgnoreCase(String nome);
}
