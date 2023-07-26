package br.com.cruzvita.geradorderelatorio.controller;

import br.com.cruzvita.geradorderelatorio.enuns.Filtros;
import br.com.cruzvita.geradorderelatorio.repository.RelatorioRepository;
import br.com.cruzvita.geradorderelatorio.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping
    public ResponseEntity<?> gerarRelatorio(@PageableDefault(size = 10) Pageable paginacao, @RequestParam Filtros filtros, String valor, String cpf){
        return relatorioService.gerarRelatorio(filtros, valor, cpf,paginacao);
    }
}
