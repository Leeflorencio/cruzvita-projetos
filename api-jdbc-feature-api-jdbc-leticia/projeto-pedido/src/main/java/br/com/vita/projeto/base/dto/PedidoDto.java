package br.com.vita.projeto.base.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDto {
    public class Pedidos {

        private String cpf;
        private LocalDateTime idProduto;
        private LocalDateTime quantidade;
        private String formaDePagamento;
        private BigDecimal cepEntrega;

        public Pedidos(String cpf, LocalDateTime idProduto, LocalDateTime quantidade, String formaDePagamento,
                       BigDecimal cepEntrega) {
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

        public LocalDateTime getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(LocalDateTime idProduto) {
            this.idProduto = idProduto;
        }

        public LocalDateTime getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(LocalDateTime quantidade) {
            this.quantidade = quantidade;
        }

        public String getFormaDePagamento() {
            return formaDePagamento;
        }

        public void setFormaDePagamento(String formaDePagamento) {
            this.formaDePagamento = formaDePagamento;
        }

        public BigDecimal getCepEntrega() {
            return cepEntrega;
        }

        public void setCepEntrega(BigDecimal cepEntrega) {
            this.cepEntrega = cepEntrega;
        }
    }
}
