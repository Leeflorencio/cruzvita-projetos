package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Respostas;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListarPedidoPorFiltro {

    @Autowired
    PedidoRepository pedidoRepository;

    public ResponseEntity<?> listar(Pageable pageable, Integer id) {
        if (pedidoRepository.existsById(id)) {
            Page<PedidoModel> page = pedidoRepository.findAllById(pageable, id);
            return ResponseEntity.status(200).body(page);
        } else {
            return ResponseEntity.status(400).body("Pedido não localizado");
        }
    }
}