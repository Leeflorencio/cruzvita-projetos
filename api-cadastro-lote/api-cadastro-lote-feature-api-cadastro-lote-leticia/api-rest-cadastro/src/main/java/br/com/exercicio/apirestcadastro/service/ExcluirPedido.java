package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExcluirPedido {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<?> excluir(String id) {
        try {
            Integer identificador = Integer.parseInt(id);
            PedidoModel pedido = pedidoRepository.getReferenceById(identificador);
            if (pedidoRepository.existsById(identificador)) {
                pedidoRepository.delete(pedido);
                return ResponseEntity.status(200).body("Pedido excluído com sucesso");
            }
            return ResponseEntity.status(400).body("Pedido não localizado, não é possível realizar a exclusão");
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID inválido. Forneça apenas números.");
        }
    }
}
