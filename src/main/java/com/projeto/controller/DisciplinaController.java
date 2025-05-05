package com.projeto.controller;

import com.projeto.domain.dto.CursoDto;
import com.projeto.domain.model.Disciplina;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DisciplinaController {
    @GetMapping
    public ResponseEntity<Iterable<Disciplina>> getCursos() {
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Disciplina> getCurso(@PathVariable("id") final Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Disciplina> saveCurso(@RequestBody @Valid CursoDto dto) {
        return null;
    }
}
