package br.com.vita.projeto.base.repository;

import br.com.vita.projeto.base.model.PedidoModel;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
@Configuration
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {
    PedidoModel findByMongoDb(String id);
}
