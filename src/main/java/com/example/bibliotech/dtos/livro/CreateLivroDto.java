package com.example.bibliotech.dtos.livro;

import java.util.Date;

public record CreateLivroDto(
    Date dataPrevista,
    int ano,
    String isbn,
    int edicao,
    int prazo,
    String nome,
    int areaId,
    String nomeAutor
) {}
