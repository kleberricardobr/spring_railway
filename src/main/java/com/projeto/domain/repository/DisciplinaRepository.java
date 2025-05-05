package com.projeto.domain.repository;

import com.projeto.domain.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByNome(String nome);
}
