package br.com.exercicio.apirestcadastro.service;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.repository.CadastroRepository;
import br.com.exercicio.apirestcadastro.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CadastrarPedido {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    CadastroRepository cadastroRepository;

    public ResponseEntity<?> realizarPedido(PedidoDto pedidoDto) {
        if (cadastroRepository.existsById(pedidoDto.getIdCliente())) {
            CadastroModel cadastroModel = cadastroRepository.findById(pedidoDto.getIdCliente()).get();

            if (cadastroModel.getStatus() == Status.INATIVO) {
                return ResponseEntity.status(400).body("Cliente inativo, o pedido não pode ser realizado.");
            }
            PedidoModel pedido = new PedidoModel(pedidoDto.getValorPedido(), pedidoDto.getCodigoItem(), cadastroModel);
            pedidoRepository.save(pedido);
            return ResponseEntity.status(200).body("Pedido realizado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não localizado, realize um cadastro antes de efetuar a compra.");
    }
}
