package br.com.vita.projeto.base.model;

import br.com.vita.projeto.base.enuns.StatusPedidos;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long idProduto;
    private Long idUsuario;
    private String ruaEntrega;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private LocalDateTime dataConclusao;
    @Enumerated(EnumType.STRING)// salvar com o nome do valor
    private StatusPedidos status = StatusPedidos.CRIADO;
    private Double valorTotal;

    private String mongoDb;

    public PedidoModel(Long idProduto, Long idUsuario, String ruaEntrega, Double valorTotal) {
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.ruaEntrega = ruaEntrega;
        this.valorTotal = valorTotal;
    }
}
