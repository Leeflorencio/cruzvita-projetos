package com.cruzvita.api.livros.controller;

import com.cruzvita.api.livros.dto.Livro;
import com.cruzvita.api.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivrosController {

    @Autowired
    LivroService livroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> adicionarLivro(@RequestBody Livro livro) {
        return livroService.adicionarLivro(livro);
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<?> excluirLivro(@RequestBody String id) {
        return livroService.excluirLivro(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarLivro(@RequestBody Integer id, Livro livro) {
        return livroService.atualizarLivro(id, livro);
    }

    @GetMapping("/listarPorId")
    public ResponseEntity<?> listarLivroId(Integer id, Pageable pageable) {
        return livroService.listarLivroId(id, pageable);
    }
}
