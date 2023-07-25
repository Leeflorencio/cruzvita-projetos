package br.com.vita.projeto.base.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String mensagem;

    public ClienteDto() {
    }

}
