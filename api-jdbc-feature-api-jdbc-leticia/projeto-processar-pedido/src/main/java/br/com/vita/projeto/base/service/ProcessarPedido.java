package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.enuns.StatusPedidos;
import br.com.vita.projeto.base.model.PedidoModelMongo;
import br.com.vita.projeto.base.model.PedidoModelNotificacao;
import br.com.vita.projeto.base.repository.PedidoMongoNotificacao;
import br.com.vita.projeto.base.repository.PedidoMongoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProcessarPedido {

    @Autowired
    PedidoMongoRepository pedidoMongoRepository;

    @Autowired
    PedidoMongoNotificacao pedidoMongoNotificacao;

    @Scheduled(fixedRate = 300000, initialDelay = 10000)
    public void processarPedidos(){
        List<PedidoModelMongo> pedidosPendentes = pedidoMongoRepository.findByStatus(StatusPedidos.PENDENTE);
        for ( PedidoModelMongo pedidoPendente: pedidosPendentes ) {
            PedidoModelNotificacao pedidoModelNotificacao = new PedidoModelNotificacao();
            BeanUtils.copyProperties(pedidoPendente, pedidoModelNotificacao);
            pedidoMongoNotificacao.save(pedidoModelNotificacao);

            pedidoPendente.setStatus(StatusPedidos.PROCESSADO);
            pedidoMongoRepository.save(pedidoPendente);
        }
    }
    @Scheduled(fixedRate = 600000, initialDelay = 120000)
    public void notificarPedido(){
        List<PedidoModelNotificacao> pedidoModelNotificacaos = pedidoMongoNotificacao.findByStatus(StatusPedidos.PENDENTE);

            //pedidoPendente.setStatus(StatusPedidos.NOTIFICADO);
        }

    }

