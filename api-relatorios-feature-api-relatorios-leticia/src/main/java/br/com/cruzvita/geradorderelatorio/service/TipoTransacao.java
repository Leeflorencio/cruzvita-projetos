package br.com.cruzvita.geradorderelatorio.service;

import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TipoTransacao {

    @Autowired
    RelatorioRepository relatorioRepository;

    public ResponseEntity<?> transacao(String valor, String cpf, Pageable paginacao) {

        if(relatorioRepository.existsByCpf(cpf)){
            if (valor.equalsIgnoreCase("compra") || (valor.equalsIgnoreCase("venda"))
                || (valor.equalsIgnoreCase("transferencia")) || (valor.equalsIgnoreCase("pagamento"))){
             return ResponseEntity.status(200).body(relatorioRepository.findByTipoTransacaoAndCpf(valor, cpf, paginacao));
            }
        return ResponseEntity.status(400).body("Escolha entre as opções de transação: Compra, Venda, Transferência ou Pagamento.");
        }
        return ResponseEntity.status(400).body("CPF incorreto");
    }
}
