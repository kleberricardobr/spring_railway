package com.projeto.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Setter
@Getter
public class CursoDto {
    private Long ID;

    @NotBlank(message = "O nome do curso deve ser informado")
    @Size(max = 500, message = "Tamanho máximo excedido para o campo nome")
    private String nome;

    private Set<String> disciplinas;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CursoDto cursoDto = (CursoDto) o;
        return Objects.equals(ID, cursoDto.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
