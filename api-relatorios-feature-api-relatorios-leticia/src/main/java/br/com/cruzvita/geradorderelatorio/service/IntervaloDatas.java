package br.com.cruzvita.geradorderelatorio.service;

import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Date;

@Service
public class IntervaloDatas extends Data{

    @Autowired
    RelatorioRepository relatorioRepository;

    public ResponseEntity<?> filtroIntervaloData(String valor, String cpf, Pageable paginacao) {

        if(relatorioRepository.existsByCpf(cpf))
        try {
            Date data = new Date();
            data = fmt.parse(valor);
            String[] datas = valor.split(" ");
            String dataIni = datas[0];
            String dataFim = datas[1];
            Date dataInicial = fmt.parse(dataIni);
            Date dataFinal = fmt.parse(dataFim);

            if(dataInicial.compareTo(dataFinal) > 0){
                return ResponseEntity.status(400).body("A data inicial deve ser menor que a data final");
            }
            return ResponseEntity.status(200).body(relatorioRepository.findAllByDataTransacaoBetweenAndCpf(dataInicial, dataFinal, cpf, paginacao));

        } catch (ParseException e) {
            return ResponseEntity.status(400).body("Data invalida");
        }
        return ResponseEntity.status(400).body("CPF incorreto");
    }
}
