package com.example.bibliotech.dtos.reserva;

import java.sql.Date;

public record CreateReservaDto(
    Date data,
    int matricula,
    int idLivro
) {}
