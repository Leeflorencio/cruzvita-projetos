package com.cruzvita.api.livros.repository;

import com.cruzvita.api.livros.model.EmprestimoModel;
import com.cruzvita.api.livros.model.LivroModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class LivroDAO {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    public void adicionarLivro(LivroModel livro) {
        livroRepository.save(livro);
    }

    public void excluirLivro(Integer id) {
        livroRepository.deleteById(id);
    }

    public void atualizarLivro(LivroModel livro){
        livroRepository.save(livro);
    }

   public boolean listar(Integer id){
      return livroRepository.existsById(id);
   }

   public LivroModel buscarLivro(Integer id){
        return livroRepository.findById(id).get();
   }

    public void emprestar(EmprestimoModel emprestimo) {
        emprestimoRepository.save(emprestimo);
    }
}
