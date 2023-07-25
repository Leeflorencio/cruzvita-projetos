package br.com.vita.projeto.base.controller;

import br.com.vita.projeto.base.dto.ProdutoDTO;
import br.com.vita.projeto.base.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public String cadastroProduto(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.cadastroProduto(produtoDTO);
    }

    @GetMapping("/consultar")
    public ResponseEntity<String> consultarProduto(@RequestParam String nome) {
        ProdutoDTO produto = produtoService.consultarProduto(nome);
        if (produto.getNome() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não localizado");
        } else{
            return  ResponseEntity.ok("Produto localizado: " + produto.toString());
        }
    }

    @GetMapping("/consultar/id/{id}")
    public ResponseEntity<?> consultarProdutoId(@PathVariable Long id){
        return produtoService.consultarId(id);
    }
}