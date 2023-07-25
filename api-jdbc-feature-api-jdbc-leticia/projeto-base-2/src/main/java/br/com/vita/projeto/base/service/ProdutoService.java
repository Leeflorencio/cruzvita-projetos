package br.com.vita.projeto.base.service;

import br.com.vita.projeto.base.ConexaoFactory;
import br.com.vita.projeto.base.dto.ProdutoDTO;
import br.com.vita.projeto.base.repository.ProdutoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;

@Service
public class ProdutoService {
    private ConexaoFactory connection;

    public ProdutoService(){
        this.connection = new ConexaoFactory();
    }

    public String cadastroProduto(ProdutoDTO produtoDTO){
        Connection conn = connection.recuperarConexao();
        String result = String.valueOf(new ProdutoDAO(conn).consultarProduto(produtoDTO.getNome()));
        if(new ProdutoDAO(conn).consultarProduto(produtoDTO.getNome()).getNome() != null){
            return "Produto ja está cadastrado no sistema!!";
        }
        new ProdutoDAO(conn).cadastroProduto(produtoDTO);
        return "Produto cadastrado com sucesso";
    }

    public ProdutoDTO consultarProduto (String nome){
        ProdutoDTO result = null;
        Connection conn = connection.recuperarConexao();
        result = new ProdutoDAO(conn).consultarProduto(nome);
        return result;
    }

    public ResponseEntity<?> consultarId(Long id) {
        ProdutoDTO result = null;
        Connection conn = connection.recuperarConexao();
        result = new ProdutoDAO(conn).consultarId(id);
        if(result.getNome() == null){
            return ResponseEntity.status(404).body("Produto não localizado!");
        }
        return ResponseEntity.status(200).body(result);
    }
}
