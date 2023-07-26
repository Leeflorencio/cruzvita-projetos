package br.com.cruzvita.geradorderelatorio.service;

import br.com.cruzvita.geradorderelatorio.enuns.Filtros;
import br.com.cruzvita.geradorderelatorio.model.RelatorioModel;
import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Data {

    @Autowired
    RelatorioRepository relatorioRepository;

    public SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public ResponseEntity<?> filtroData(String valor, String cpf, Pageable paginacao) {
            Date data = null;

        if(relatorioRepository.existsByCpf(cpf)){
            try {
                data = fmt.parse(valor);
                Page<RelatorioModel> pagina = relatorioRepository.findAllByDataTransacaoAndCpf(data,cpf,paginacao);
                if(pagina.hasContent()){
                    return ResponseEntity.status(200).body(pagina);
                }
                return ResponseEntity.status(400).body("Não existe registro para a data informada");
            } catch (ParseException e) {
                return ResponseEntity.status(400).body("Data invalida");
            }
        }
        return ResponseEntity.status(400).body("CPF incorreto");
    }
}
