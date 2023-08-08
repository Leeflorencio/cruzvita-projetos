package com.cruzvita.api.livros.repository;

import com.cruzvita.api.livros.dto.Livro;
import com.cruzvita.api.livros.model.LivroModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {

    LivroModel getReferenceById(Integer id);

    Page<LivroModel> findAllById(Pageable pageable, Integer id);
    //LivroModel findByTituloAndAndAutor(String titulo, String autor);


}
