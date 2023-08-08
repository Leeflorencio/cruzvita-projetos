package br.com.exercicio.apirestcadastro.repository;

import br.com.exercicio.apirestcadastro.model.PedidoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

    PedidoModel getReferenceById(Integer id);
    Page<PedidoModel> findAllById(Pageable pageable, Integer id);

}
