package com.projeto.service;

import com.projeto.domain.dto.AlunoDto;
import com.projeto.domain.dto.CursoDto;
import com.projeto.domain.model.Aluno;
import com.projeto.domain.model.Curso;
import com.projeto.domain.repository.AlunoRepository;
import com.projeto.domain.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Iterable<Aluno> getAlunos() {
        return this.alunoRepository.findAll();
    }

    @Override
    public Aluno getAluno(String ra) {
        return this.alunoRepository.findByRA(ra);
    }

    @Override
    public Aluno saveAluno(AlunoDto dto) {
        var cursos = this.getCursosFromDtos(dto.getCursos());

        if (this.alunoRepository.findByRA(dto.getRA()) != null) {
            throw new IllegalArgumentException("RA já utilizado em outro cadastro!");
        }

        var aluno = Aluno
                .builder()
                .RA(dto.getRA())
                .nome(dto.getNome())
                .cursos(cursos)
                .build();

        return this.alunoRepository.save(aluno);
    }

    private Set<Curso> getCursosFromDtos(Set<CursoDto> dto) {
        if (dto == null)
            return null;

        return dto.stream().map(
                u -> {
                    return this.cursoRepository
                            .findByNomeIgnoreCase(u.getNome())
                            .orElseThrow(() -> new NoSuchElementException("Curso não encontrado"));
                }
        ).collect(Collectors.toSet());
    }
}
