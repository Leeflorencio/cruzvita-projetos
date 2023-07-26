package br.com.cruzvita.geradorderelatorio.repository;

import br.com.cruzvita.geradorderelatorio.model.RelatorioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RelatorioRepository extends JpaRepository<RelatorioModel, Integer> {

    Boolean existsByCpfBeneficiado(String cpfBeneficiado);
    Boolean existsByCpf(String cpf);
    Page<RelatorioModel> findAllByDataTransacaoAndCpf(Date data, String cpf, Pageable paginacao);

    Page<RelatorioModel> findByTipoTransacaoAndCpf(String transacao, String cpf, Pageable pageable);

    Page<RelatorioModel> findByCpfBeneficiadoAndCpf(String cpfBeneficiado, String cpf, Pageable pageable);

    Page<RelatorioModel> findAllByDataTransacaoBetweenAndCpf(Date dataInicial,Date dataFinal, String cpf, Pageable pageable);
    //between essa condição recupera no banco de dados as linhas que estejam entre dois ou mais valores passados como parametro

}