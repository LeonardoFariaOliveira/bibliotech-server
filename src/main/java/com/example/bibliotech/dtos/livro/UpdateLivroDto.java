package com.example.bibliotech.dtos.livro;

import java.util.Date;

public record UpdateLivroDto(
    boolean disponivel,
    Date dataPrevista,
    int tituloId 
) {}
