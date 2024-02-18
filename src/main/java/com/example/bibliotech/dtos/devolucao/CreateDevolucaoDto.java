package com.example.bibliotech.dtos.devolucao;

import java.util.Date;

public record CreateDevolucaoDto(
    Date dataDevolucao,
    double valorTotal,
    int idEmprestimo
) {}
