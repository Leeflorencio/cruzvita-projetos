package br.com.exercicio.apirestcadastro.Dto;

import br.com.exercicio.apirestcadastro.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {

    private String nome;
    private String email;
    private Status status;
}