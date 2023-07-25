package br.com.vita.projeto.base.repository;

import br.com.vita.projeto.base.model.PedidoModelMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoMongoRepository extends MongoRepository<PedidoModelMongo,String> {

}
