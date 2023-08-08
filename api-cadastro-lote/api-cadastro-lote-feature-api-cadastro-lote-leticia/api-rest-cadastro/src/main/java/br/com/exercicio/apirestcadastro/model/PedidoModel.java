package br.com.exercicio.apirestcadastro.model;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
public class PedidoModel {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private Integer id;
   private LocalDate dataPedido = LocalDate.now();
   private Double valorPedido;
   private Integer codigoItem;

   @ManyToOne
   @JoinColumn(name = "idCliente", referencedColumnName = "id")
   private CadastroModel cadastroModel; //relacionamento com a tabela de usuarios

   public PedidoModel(Double valorPedido, Integer codigoItem, CadastroModel cadastroModel) {
      this.valorPedido = valorPedido;
      this.codigoItem = codigoItem;
      this.cadastroModel = cadastroModel;
   }

   public void atualizar(PedidoDto pedidoDto) {
      if(pedidoDto.getCodigoItem() != null){
         this.codigoItem = pedidoDto.getCodigoItem();
      }
      if(pedidoDto.getValorPedido() != null){
         this.valorPedido = pedidoDto.getValorPedido();
      }
   }
}
