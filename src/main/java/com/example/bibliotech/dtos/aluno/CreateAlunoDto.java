package com.example.bibliotech.dtos.aluno;

public record CreateAlunoDto(
    String nome,
    String cpf,
    String endereco
) {}
