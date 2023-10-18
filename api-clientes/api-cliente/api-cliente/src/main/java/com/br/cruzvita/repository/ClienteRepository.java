package com.br.cruzvita.repository;

import com.br.cruzvita.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    boolean existsByNome(String nome);

    boolean existsByEmail(String email);


}
