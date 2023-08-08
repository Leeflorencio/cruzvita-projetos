package com.cruzvita.api.livros.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Emprestimo {
    private Integer idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}
