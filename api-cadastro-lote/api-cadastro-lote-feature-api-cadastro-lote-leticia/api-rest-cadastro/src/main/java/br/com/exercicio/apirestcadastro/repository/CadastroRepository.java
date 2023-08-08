package br.com.exercicio.apirestcadastro.repository;

import br.com.exercicio.apirestcadastro.enums.Status;
import br.com.exercicio.apirestcadastro.model.CadastroModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, Integer> {

    Boolean existsAllByEmailAndStatus(String email, Status status);
    CadastroModel getReferenceById(Integer id);
    Page<CadastroModel> findByEmail(String email, Pageable pageable);
    Page<CadastroModel> findByStatus(Status status, Pageable pageable);
}
