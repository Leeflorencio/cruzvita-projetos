package br.com.vita.projeto.base.dto;

public class JsonDto {

    private String cpf;
    private Long idProduto;
    private int quantidade;
    private String formaDePagamento;
    private String cepEntrega;

    public JsonDto(String cpf, Long idProduto, int quantidade, String formaDePagamento, String cepEntrega) {
        this.cpf = cpf;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.formaDePagamento = formaDePagamento;
        this.cepEntrega = cepEntrega;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }
}
