package br.com.vita.projeto.base.dto;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int qdtEstoque;

    public ProdutoDTO(){}
    public ProdutoDTO(String nome, String descricao, double preco, int qdtEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qdtEstoque = qdtEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQdtEstoque() {
        return qdtEstoque;
    }

    public void setQdtEstoque(int qdtEstoque) {
        this.qdtEstoque = qdtEstoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s\nDescrição: %s\nPreço: %s\nQuantidade em estoque: %s\n",
                nome, descricao, preco, qdtEstoque);
    }
}
