package com.br.cruzvita.dto;

import com.br.cruzvita.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {


    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    //@JsonIgnore
    private String telefone;

    @NotBlank(message = "Insira um e-mail válido")
    private String email;

    @NotBlank(message = "O campo de endereço não pode estar vazio")
    private String endereco;

    private Status status;
}
