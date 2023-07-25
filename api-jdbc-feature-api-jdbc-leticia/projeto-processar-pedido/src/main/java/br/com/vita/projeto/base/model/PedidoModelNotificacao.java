package br.com.vita.projeto.base.model;

import br.com.vita.projeto.base.enuns.StatusPedidos;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@Document(collection = "notificacao")
public class PedidoModelNotificacao {

    @Id
    private String id;
    private Long idProduto;
    private Long idUsuario;
    private String ruaEntrega;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private LocalDateTime dataConclusao;
    @Enumerated(EnumType.STRING)// salvar com o nome do valor
    private StatusPedidos status = StatusPedidos.PENDENTE;
    private Double valorTotal;

    public PedidoModelNotificacao(){}
    public PedidoModelNotificacao(Long idProduto, Long idUsuario, String ruaEntrega, Double valorTotal) {
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.ruaEntrega = ruaEntrega;
        this.valorTotal = valorTotal;
    }
}
