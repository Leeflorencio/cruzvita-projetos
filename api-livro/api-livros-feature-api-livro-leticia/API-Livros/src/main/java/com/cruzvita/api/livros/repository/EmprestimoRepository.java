package com.cruzvita.api.livros.repository;

import com.cruzvita.api.livros.model.EmprestimoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Integer> {

}
