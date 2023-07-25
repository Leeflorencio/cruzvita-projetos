package br.com.vita.projeto.base.controller;

import br.com.vita.projeto.base.dto.JsonDto;
import br.com.vita.projeto.base.model.PedidoModel;
import br.com.vita.projeto.base.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService service;

    // Endpoint para criar um pedido
    @PostMapping("/realizarPedido")
    public ResponseEntity<String> realizarPedido(@RequestBody JsonDto jsonDto) {
        return service.realizarPedido(jsonDto);
    }

	@GetMapping("/consultarPedido/{id}")
    public ResponseEntity<?> consultarPedido(@PathVariable Integer id){
        return service.consultarPedido(id);
    }

    @PutMapping("/atualizar/{pedidos}")
    public ResponseEntity<?> atualizarPedido(@RequestParam Integer id){
        return service.atualizar(id);
    }

    @GetMapping("/mongoId/{id}")
    public ResponseEntity<?> listarIdMongo(@PathVariable String id){
        return service.buscarPedidoMongo(id);
    }
}
