package com.br.cruzvita.service;

import com.br.cruzvita.dto.ClienteDto;
import com.br.cruzvita.enums.Status;
import com.br.cruzvita.model.ClienteModel;
import com.br.cruzvita.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    @Override
    public ResponseEntity<Object> cadastrar(ClienteDto cliente) {

        if (repository.existsByNome(cliente.getNome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O cliente já está cadastrado");
        }
        if (repository.existsByEmail(cliente.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O e-mail já está cadastrado");
        }
        if (!nomeValido(cliente.getNome()) || cliente.getNome().isBlank() || !emailValido(cliente.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O campo nome e e-mail precisam ser válidos e não podem estar vazios");
        }
        if (!telefoneValido(cliente.getTelefone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Informe um número de telefone válido");
        }
        var clienteModel = new ClienteModel();

        BeanUtils.copyProperties(cliente, clienteModel);
        clienteModel.setDataCriacao(LocalDateTime.now(ZoneId.of("UTC")));
        repository.save(clienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
    }

    private boolean nomeValido(String nome) {
        return nome.matches("^[A-Za-z\\s]+$");
    }

    private boolean emailValido(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$");
    }

    private boolean telefoneValido(String telefone) {
        return telefone.matches("^+?[0-9]{1,3}-?[0-9]{4,14}$");
    }

    @Override
    public ResponseEntity<?> listarTodos(Pageable pageable) {
        try {
            Page<ClienteModel> clienteModels = repository.findAll(pageable);
            if (clienteModels.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há registros no sistema");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteModels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @Override
    public ResponseEntity<Object> listarPorId(UUID id) {
        try {
            if (repository.existsById(id)) {
                Optional<ClienteModel> cliente = repository.findById(id);
                return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não localizado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro");
        }
    }

    @Override
    public ResponseEntity<Object> deletar(UUID id) {
        try {
            Optional<ClienteModel> clienteModel = repository.findById(id);
            if (clienteModel.isPresent()) {
                ClienteModel cliente = clienteModel.get();
                cliente.setStatus(Status.INATIVO);
                repository.save(cliente);
                return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não localizado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);

        }
    }

    @Override
    public ResponseEntity<Object> atualizar(UUID id, ClienteDto cliente) {
        try {
            Optional<ClienteModel> clienteModel = repository.findById(id);
            if (!clienteModel.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não localizado");
            }
            if (!nomeValido(cliente.getNome()) || cliente.getNome().isBlank() || !emailValido(cliente.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("O campo nome e e-mail precisam ser válidos e não podem estar vazios");
            } else{
                ClienteModel usuario = clienteModel.get();
                usuario.setNome(cliente.getNome());
                usuario.setEmail(cliente.getEmail());
                usuario.setEndereco(cliente.getEndereco());
                usuario.setTelefone(cliente.getTelefone());
                repository.save(usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body("Cliente atualizado com sucesso");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
}
}

