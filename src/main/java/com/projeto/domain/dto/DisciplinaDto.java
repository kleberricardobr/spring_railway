package com.projeto.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaDto {
    @NotBlank(message = "O nome da disciplina deve ser informado")
    @Size(max = 255, message = "Tamanho máximo excedido para o campo nome")
    private String nome;

    @NotBlank(message = "O código do curso deve ser informado")
    private Long cursoID;
}
