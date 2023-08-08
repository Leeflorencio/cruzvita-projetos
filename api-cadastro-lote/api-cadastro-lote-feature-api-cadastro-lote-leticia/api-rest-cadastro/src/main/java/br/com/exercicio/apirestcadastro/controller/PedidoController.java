package br.com.exercicio.apirestcadastro.controller;

import br.com.exercicio.apirestcadastro.Dto.PedidoDto;
import br.com.exercicio.apirestcadastro.enums.Filtros;
import br.com.exercicio.apirestcadastro.model.PedidoModel;
import br.com.exercicio.apirestcadastro.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {

    @Autowired
    PedidoService pedidoService;


    @Transactional
    @PostMapping("/cadastrar/pedido")
    public ResponseEntity<?>gerarPedido(@RequestBody PedidoDto pedidoDto){
        return pedidoService.gerarPedido(pedidoDto);
    }

    @PutMapping("/atualizar/pedido")
    public ResponseEntity<?>atualizarPedido(@RequestBody String id, PedidoDto pedidoDto){
        return pedidoService.atualizarPedido(id,pedidoDto);
    }

    @DeleteMapping("/excluir/pedido")
    public ResponseEntity<?>excluirPedido(@RequestBody String id){
        return pedidoService.excluirPedido(id);
    }

    @GetMapping("/listar/pedido")
    public ResponseEntity<Page<PedidoModel>> listarPedidos(Pageable pageable){
        return pedidoService.listarPedidos(pageable);
    }

    @GetMapping("/listar-id/pedido")
    public ResponseEntity<?> listarPorId(Pageable pageable, Integer id){
        return pedidoService.listarPorId(pageable, id);
    }
}
