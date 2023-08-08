package com.cruzvita.api.livros.model;

import com.cruzvita.api.livros.dto.Livro;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "emprestimos")
public class EmprestimoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idLivro", referencedColumnName = "id")
    private LivroModel livroModel;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    public EmprestimoModel(LivroModel livroModel, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livroModel = livroModel;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
