package com.projeto.service;

import com.projeto.domain.dto.CursoDto;
import com.projeto.domain.model.Curso;

import java.util.Set;

public interface CursoService {
    public Iterable<Curso> getCursos();
    public Curso getCurso(final Long id);
    public Curso saveCurso(final CursoDto dto);
}
