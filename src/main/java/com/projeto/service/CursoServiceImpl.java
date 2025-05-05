package com.projeto.service;

import com.projeto.domain.dto.CursoDto;
import com.projeto.domain.model.Curso;
import com.projeto.domain.model.Disciplina;
import com.projeto.domain.repository.CursoRepository;
import com.projeto.domain.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    final CursoRepository cursoRepository;
    final DisciplinaRepository disciplinaRepository;

    public CursoServiceImpl(CursoRepository cursoRepository, DisciplinaRepository disciplinaRepository) {
        this.cursoRepository = cursoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public Iterable<Curso> getCursos() {
        return this.cursoRepository.findAll();
    }

    @Override
    public Curso getCurso(final Long id) {
        return this.cursoRepository.findById(id).orElseGet(() -> null);
    }

    @Override
    public Curso saveCurso(CursoDto dto) {
        this.cursoRepository
                .findByNome(dto.getNome())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Curso já cadastrado!");
                });

        var disciplinas = this.getDisciplinasFromDtos(dto.getDisciplinas());
        var curso = Curso
                .builder()
                .nome(dto.getNome())
                .disciplinas(disciplinas)
                .build();

        return this.cursoRepository.save(curso);
    }

    private Set<Disciplina> getDisciplinasFromDtos(Set<String> dtos) {
        if (dtos == null)
            return null;

        return dtos.stream().map(
                u -> {
                    return this.disciplinaRepository
                            .findByNome(u)
                            .orElseGet(() -> this.disciplinaRepository.save(
                                    Disciplina.builder()
                                            .nome(u)
                                            .build()
                            ));
                }
        ).collect(Collectors.toSet());
    }
}
