package com.example.bibliotech.dtos.titulo;



public record CreateTituloDto(
    int ano,
    String isbn,
    int edicao,
    int prazo,
    String nome,
    int areaId
) {}
/*
 *  titulo.get().setAno(object.getAno());
        titulo.get().setIsbn(object.getIsbn());
        titulo.get().setNome(object.getNome());
        titulo.get().setArea(object.getArea());
 */