package com.projeto.controller;

import com.projeto.domain.dto.CursoDto;
import com.projeto.domain.model.Aluno;
import com.projeto.domain.model.Curso;
import com.projeto.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping
    public ResponseEntity<Iterable<Curso>> getCursos() {
        return new ResponseEntity<>(this.cursoService.getCursos(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Curso> getCurso(@PathVariable("id") final Long id) {
        var curso = this.cursoService.getCurso(id);
        return new ResponseEntity<>(curso, curso == null? HttpStatus.NOT_FOUND: HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Curso> saveCurso(@RequestBody @Valid CursoDto dto) {
        var curso = this.cursoService.saveCurso(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(curso.getId());

        return ResponseEntity.created(uri).build();
    }
}
