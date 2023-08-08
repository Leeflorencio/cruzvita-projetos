package br.com.exercicio.apirestcadastro.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

    //private Integer id;
    private Double valorPedido;
    private Integer idCliente;
    private Integer codigoItem;

}
