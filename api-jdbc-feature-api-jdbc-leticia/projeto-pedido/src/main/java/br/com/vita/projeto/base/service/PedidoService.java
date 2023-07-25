package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.dto.ClienteDto;
import br.com.vita.projeto.base.dto.JsonDto;
import br.com.vita.projeto.base.dto.ProdutoDto;
import br.com.vita.projeto.base.enuns.StatusPedidos;
import br.com.vita.projeto.base.model.PedidoModel;
import br.com.vita.projeto.base.model.PedidoModelMongo;
import br.com.vita.projeto.base.repository.PedidoMongoRepository;
import br.com.vita.projeto.base.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PedidoService {
    @Autowired
    ClienteRest clientRest;

    @Autowired
    ProdutoRest produtoRest;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PedidoMongoRepository pedidoMongoRepository;

    public ResponseEntity<String> realizarPedido(JsonDto jsonDto) {
        ClienteDto clienteDto = null;
        try{
            clienteDto = clientRest.buscarCliente(jsonDto.getCpf());
        }catch (HttpClientErrorException e){
            return ResponseEntity.status(404).body("Cliente não localizado");
        }

        ProdutoDto produtoDto = null;
        try{
            produtoDto = produtoRest.buscarProduto(jsonDto.getIdProduto());
        }catch (HttpClientErrorException e){
            return ResponseEntity.status(404).body("produto não localizado");
        }

        if(jsonDto.getQuantidade() > produtoDto.getQdtEstoque()){
            return ResponseEntity.status(409).body("Quantidade solicitada maior que em estoque");
        }

        PedidoModel pedido = new PedidoModel(jsonDto.getIdProduto(), clienteDto.getId(), clienteDto.getEndereco(), produtoDto.getPreco() * jsonDto.getQuantidade());

        PedidoModelMongo pedidoModelMongo = new PedidoModelMongo(jsonDto.getIdProduto(), clienteDto.getId(), clienteDto.getEndereco(), produtoDto.getPreco() * jsonDto.getQuantidade());

        pedido.setMongoDb(pedidoMongoRepository.save(pedidoModelMongo).getId());
        pedidoRepository.save(pedido);

        return ResponseEntity.status(200).body("Pedido realizado com sucesso!");
    }

    public ResponseEntity<?> consultarPedido(Integer id) {
        if(!pedidoRepository.existsById(id)){
            return ResponseEntity.status(404).body("Pedido não localizado");
        }
        return ResponseEntity.status(200).body(pedidoRepository.findById(id));
    }

    public ResponseEntity<?> atualizar(Integer id) {
        if(!pedidoRepository.existsById(id)){
            return ResponseEntity.status(404).body("Id não localizado");
        }
        PedidoModel pedido = pedidoRepository.findById(id).get(); //pega o id e adiciona a variavel pedido
        pedido.setStatus(StatusPedidos.PROCESSADO); //altera o status
        pedidoRepository.save(pedido); //salva o pedido
        return ResponseEntity.status(200).body("Pedido atualizado com sucesso"); //retorna a mensagem amigavel
    }

    public ResponseEntity<?> buscarPedidoMongo(String id) {
        if(pedidoMongoRepository.existsById(id)){
            return ResponseEntity.status(404).body("Id não localizado");
        }
        return ResponseEntity.status(200).body(pedidoRepository.findByMongoDb(id));
    }
}