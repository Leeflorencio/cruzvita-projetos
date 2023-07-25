package br.com.vita.projeto.base.repository;

import br.com.vita.projeto.base.enuns.StatusPedidos;
import br.com.vita.projeto.base.model.PedidoModelMongo;
import br.com.vita.projeto.base.model.PedidoModelNotificacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoMongoNotificacao extends MongoRepository<PedidoModelNotificacao,String> {

    List<PedidoModelNotificacao> findByStatus(StatusPedidos statusPedidos);
}
