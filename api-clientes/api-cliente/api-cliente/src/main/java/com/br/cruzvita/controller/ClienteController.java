package com.br.cruzvita.controller;

import com.br.cruzvita.dto.ClienteDto;
import com.br.cruzvita.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/teste")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Welcome to Gateway test");
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid ClienteDto cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<?> listarTodos(@RequestParam Integer paginas, Integer registros) {
        Pageable pageable = PageRequest.of(paginas - 1, registros);
        return clienteService.listarTodos(pageable);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") UUID id) {
        return clienteService.listarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value = "id") UUID id) {
        return clienteService.deletar(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") UUID id, @RequestBody ClienteDto cliente) {
        return clienteService.atualizar(id, cliente);
    }
}
