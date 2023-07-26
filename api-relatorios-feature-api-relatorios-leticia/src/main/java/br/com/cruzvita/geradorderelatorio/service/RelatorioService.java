package br.com.cruzvita.geradorderelatorio.service;

import br.com.cruzvita.geradorderelatorio.enuns.Filtros;
import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;

@Service
public class RelatorioService {

    @Autowired
    RelatorioRepository relatorioRepository;
    @Autowired
    Data data;
    @Autowired
    TipoTransacao tipoTransacao;
    @Autowired
    CpfBeneficiado cpfBeneficiado;
    @Autowired
    IntervaloDatas intervaloDatas;

    private SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public ResponseEntity<?> gerarRelatorio(Filtros filtros, String valor, String cpf, Pageable paginacao) {

        if (filtros.equals(Filtros.DATA)){
            return data.filtroData(valor, cpf, paginacao);
        }

        if (filtros.equals(Filtros.TIPO_TRANSACAO)){
            return tipoTransacao.transacao(valor, cpf, paginacao);
        }

        if (filtros.equals(Filtros.CPF_BENEFICIADO)){
            return cpfBeneficiado.beneficiado(valor, cpf, paginacao);
        }

        if(filtros.equals(Filtros.INTERVALO_DATAS)){
            return intervaloDatas.filtroIntervaloData(valor, cpf, paginacao);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Escolha uma opção valida");
    }

}
