package br.com.cruzvita.geradorderelatorio.service;

import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CpfBeneficiado {

    @Autowired
    RelatorioRepository relatorioRepository;

    public ResponseEntity<?> beneficiado(String valor, String cpf, Pageable paginacao) {

        if(relatorioRepository.existsByCpfBeneficiado(valor) && relatorioRepository.existsByCpf(cpf)){
            return ResponseEntity.status(200).body(relatorioRepository.findByCpfBeneficiadoAndCpf(valor, cpf, paginacao));
        }
        return ResponseEntity.status(400).body("Verifique se o seu CPF ou do beneficiado estão corretos");
    }
}