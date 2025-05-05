package com.projeto.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AlunoDto {
    @NotBlank(message = "O nome do aluno deve ser informado")
    @Size(max = 500, message = "Tamanho máximo excedido para o campo nome (500)")
    private String nome;

    @NotBlank(message = "O campo RA deve ser informado")
    @JsonAlias(value = "RA")
    private String RA;

    private Set<CursoDto> cursos;
}
