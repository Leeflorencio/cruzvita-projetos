package br.com.vita.projeto.base.dto;

import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int qdtEstoque;

}
