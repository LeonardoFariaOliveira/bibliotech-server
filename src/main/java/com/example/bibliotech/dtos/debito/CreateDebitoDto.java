package com.example.bibliotech.dtos.debito;

import java.util.Date;

public record CreateDebitoDto(
    double valor,
    int matricula
) {}
