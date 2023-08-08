package com.cruzvita.api.livros.controller;

import com.cruzvita.api.livros.dto.Emprestimo;
import com.cruzvita.api.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    LivroService livroService;

    @PostMapping("/emprestar")
    public ResponseEntity<?> emprestar(Emprestimo emprestimo){
        return livroService.emprestar(emprestimo.getIdLivro(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
    }

    @PutMapping("/devolver")
    public ResponseEntity<?> devolver(@RequestParam Integer idLivro){
        return livroService.devolver(idLivro);
    }

}
