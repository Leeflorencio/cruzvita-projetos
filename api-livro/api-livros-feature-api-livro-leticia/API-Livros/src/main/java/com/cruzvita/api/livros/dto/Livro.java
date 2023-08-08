package com.cruzvita.api.livros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    private String titulo;
    private String autor;
    private String categoria;

}
