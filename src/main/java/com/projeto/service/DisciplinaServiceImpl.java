package com.projeto.service;

import com.projeto.domain.dto.DisciplinaDto;
import com.projeto.domain.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    final DisciplinaRepository disciplinaRepository;

    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public Iterable<DisciplinaService> getDisciplinas() {
        return null;
    }

    @Override
    public DisciplinaService getDisciplina(String ra) {
        return null;
    }

    @Override
    public DisciplinaService saveDisciplina(DisciplinaDto dto) {
        return null;
    }

}
