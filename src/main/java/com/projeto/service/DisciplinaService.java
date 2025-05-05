package com.projeto.service;


import com.projeto.domain.dto.DisciplinaDto;
import com.projeto.domain.model.Disciplina;

import java.util.Set;

public interface DisciplinaService {
    public Iterable<DisciplinaService> getDisciplinas();
    public DisciplinaService getDisciplina(final String ra);
    public DisciplinaService saveDisciplina(final DisciplinaDto dto);

}
