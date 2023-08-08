package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import br.com.exercicio.apirestcadastro.Dto.UsuarioDto;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import br.com.exercicio.apirestcadastro.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPedido {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> atualizar(String id, PedidoDto pedidoDto) {
        try {
            Integer identificador = Integer.parseInt(id);
            PedidoModel pedido = pedidoRepository.getReferenceById(identificador);
            if (!cadastroRepository.existsById(identificador) || pedido == null) {
                return ResponseEntity.status(400).body("Pedido não localizado no sistema");
            } else {
                pedido.atualizar(pedidoDto);
                pedidoRepository.save(pedido);
                return ResponseEntity.status(200).body("Pedido atualizado com sucesso");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID inválido. Forneça apenas números.");
        }
    }
}