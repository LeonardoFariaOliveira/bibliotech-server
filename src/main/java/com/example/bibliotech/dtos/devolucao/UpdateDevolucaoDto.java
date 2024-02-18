package com.example.bibliotech.dtos.devolucao;

import java.util.Date;

public record UpdateDevolucaoDto(
    Date dataDevolucao,
    double valorTotal,
    int atraso,
    int multa
) {}
