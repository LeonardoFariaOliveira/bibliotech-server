package com.example.bibliotech.dtos.debito;

import java.util.Date;

public record CreateDebitoDto(
    Date dataDebito,
    double valor,
    int matricula
) {}
