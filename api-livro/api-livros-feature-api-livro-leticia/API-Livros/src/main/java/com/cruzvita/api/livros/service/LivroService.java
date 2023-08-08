package com.cruzvita.api.livros.service;

import com.cruzvita.api.livros.dto.Livro;
import com.cruzvita.api.livros.model.EmprestimoModel;
import com.cruzvita.api.livros.model.LivroModel;
import com.cruzvita.api.livros.repository.LivroDAO;
import com.cruzvita.api.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroDAO livroDAO;

    @Autowired
    LivroRepository livroRepository;

    public ResponseEntity<?> adicionarLivro(Livro livro) {
        try {
            LivroModel livroModel = new LivroModel();
            if (livro.getCategoria().isBlank() || livro.getAutor().isBlank() || livro.getTitulo().isBlank()) {
                return ResponseEntity.status(400).body("É necessário preencher todos os campos");
            }
            livroModel.setAutor(livro.getAutor());
            livroModel.setCategoria(livro.getCategoria());
            livroModel.setTitulo(livro.getTitulo());
            livroDAO.adicionarLivro(livroModel);
            return ResponseEntity.status(201).body("Livro adicionado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("livro já esta cadastro");
        }
    }

    public ResponseEntity<?> excluirLivro(String id) {
        try {
            Integer ident = Integer.parseInt(id);
            if (!livroRepository.existsById(ident)) {
                return ResponseEntity.status(400).body("Livro não localizado");
            } else {
                livroDAO.excluirLivro(Integer.valueOf(String.valueOf(ident)));
                return ResponseEntity.status(200).body("Livro excluido com sucesso");
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Informe um ID válido");
        }
    }

    public ResponseEntity<?> atualizarLivro(Integer id, Livro livro) {
        try {
            LivroModel livros = livroRepository.getReferenceById(id);
            if (!livroRepository.existsById(id) || livro == null) {
                return ResponseEntity.status(400).body("Livro não localizado na biblioteca");
            } else {
                livros.atualizar(livro);
                livroDAO.atualizarLivro(livros);
                return ResponseEntity.status(201).body("Livro atualizado com sucesso");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID inválido. Forneça apenas números.");
        }
    }

    public ResponseEntity<?> listarLivroId(Integer id, Pageable pageable) {
        if (livroDAO.listar(id)) {
            Page<LivroModel> pagina = livroRepository.findAllById(pageable, id);
            return ResponseEntity.status(200).body(pagina);
        } else {
            return ResponseEntity.status(400).body("Livro não localizado");
        }
    }

    public ResponseEntity<?> emprestar(Integer idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        if (!livroDAO.listar(idLivro)) {
            return ResponseEntity.status(400).body("Livro não localizado");
        }
        if (dataDevolucao.isBefore(dataEmprestimo)) {
            return ResponseEntity.status(400).body("A data de devolução está incorreta");
        }
        LivroModel livroModel = livroDAO.buscarLivro(idLivro);

        if (livroModel.getEmprestado()) {
            return ResponseEntity.status(400).body("Livro já emprestado");
        }
        EmprestimoModel emprestimo = new EmprestimoModel(livroDAO.buscarLivro(idLivro), dataEmprestimo, dataDevolucao);

        livroModel.setEmprestado(true);
        livroDAO.atualizarLivro(livroModel);
        livroDAO.emprestar(emprestimo);
        return ResponseEntity.status(201).body(emprestimo);
    }

    public ResponseEntity<?> devolver(Integer idLivro) {
        if (!livroDAO.listar(idLivro)) {
            return ResponseEntity.status(400).body("Livro não localizado");
        }
        LivroModel livroModel = livroDAO.buscarLivro(idLivro);
        if(!livroModel.getEmprestado()){
            return ResponseEntity.status(400).body("Livro não está emprestado");
        }
        livroModel.setEmprestado(false);
        livroDAO.atualizarLivro(livroModel);
        return ResponseEntity.status(200).body("Livro devolvido com sucesso!");
    }


}

