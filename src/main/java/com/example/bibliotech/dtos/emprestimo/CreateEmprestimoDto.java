package com.example.bibliotech.dtos.emprestimo;

import java.util.ArrayList;
import java.util.Date;

import com.example.bibliotech.models.ItemEmprestimo;

public record CreateEmprestimoDto(
    int matricula,
    ArrayList<ItemEmprestimo> itensEmprestimo,
    Date dataDevolucao,
    double valorTotal
) {}
