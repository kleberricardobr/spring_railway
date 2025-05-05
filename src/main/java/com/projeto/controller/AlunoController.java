package com.projeto.controller;

import com.projeto.domain.dto.AlunoDto;
import com.projeto.domain.model.Aluno;
import com.projeto.service.AlunoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.UriBuilderFactoryArgumentResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(final AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> getAlunos() {
        var alunos = this.alunoService.getAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping(path = "/{ra}")
    public ResponseEntity<Aluno> getAluno(@PathVariable("ra") final String ra){
        var aluno = this.alunoService.getAluno(ra);
        return new ResponseEntity<>(aluno, aluno == null ? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody @Valid AlunoDto dto) {
        var aluno = Aluno
                .builder()
                .RA(dto.getRA())
                .nome(dto.getNome())
                .build();

        aluno = this.alunoService.saveAluno(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{ra}")
                .build(aluno.getRA());

        return ResponseEntity.created(uri).build();
    }
}
