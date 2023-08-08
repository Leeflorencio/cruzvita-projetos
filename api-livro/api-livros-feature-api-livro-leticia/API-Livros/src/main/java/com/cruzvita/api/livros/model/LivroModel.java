package com.cruzvita.api.livros.model;

import com.cruzvita.api.livros.dto.Livro;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class LivroModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String titulo;
    private String autor;
    private String categoria;

    @Column(nullable = false)
    private Boolean emprestado = false;

    public void atualizar(Livro livro) {
        if (livro.getTitulo() != null) {
            this.titulo = livro.getTitulo();
        }
        if (livro.getCategoria() != null) {
            this.categoria = livro.getCategoria();
        }
        if (livro.getAutor() != null) {
            this.autor = livro.getAutor();
        }
    }
}
