package com.br.cruzvita.service;

import com.br.cruzvita.dto.ClienteDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public interface ClienteService {

     ResponseEntity<Object> cadastrar(ClienteDto cliente);

    ResponseEntity<?> listarTodos(Pageable pageable);

    ResponseEntity<Object> listarPorId(@PathVariable(value = "id") UUID id);

    ResponseEntity<Object> deletar(UUID id);

    ResponseEntity<Object> atualizar(UUID id, ClienteDto cliente);
}
