package com.projeto.domain.repository;

import com.projeto.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    public Aluno findByRA(String ra);
}
