package com.projeto.service;

import com.projeto.domain.dto.AlunoDto;
import com.projeto.domain.model.Aluno;

public interface AlunoService {
    public Iterable<Aluno> getAlunos();
    public Aluno getAluno(final String ra);
    public Aluno saveAluno(final AlunoDto dto);
}
