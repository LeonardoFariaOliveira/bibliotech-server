package com.example.bibliotech.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;

@Entity
public class Devolucao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dataDevolucao;

    private double valorTotal;

    private double multa;

    private int atraso;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Emprestimo emprestimo;

    @JsonIgnore
    @OneToMany(mappedBy = "devolucao", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<ItemDevolucao> itensDevolucao = new ArrayList<>();

    public List<ItemDevolucao> getItensDevolucao() {
        return itensDevolucao;
    }

    public void setItensDevolucao(List<ItemDevolucao> itensDevolucao) {
        this.itensDevolucao = itensDevolucao;
    }

    public Devolucao(int id, Date dataDevolucao, double valorTotal, double multa, int atraso) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.multa = multa;
        this.atraso = atraso;
    }

    public Devolucao(Date dataDevolucao, double valorTotal, double multa, int atraso) {
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.multa = multa;
        this.atraso = atraso;
    }

    public Devolucao(Date dataDevolucao, double valorTotal, double multa, int atraso, Emprestimo empresimo) {
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = valorTotal;
        this.multa = multa;
        this.atraso = atraso;
        this.emprestimo = empresimo;
    }

    public Devolucao() {
        this.id = 0;
        this.dataDevolucao = new Date();
        this.valorTotal = 0.0;
        this.multa = 0;
        this.atraso = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public int getAtraso() {
        return atraso;
    }

    public void setAtraso(int atraso) {
        this.atraso = atraso;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    // private emprestimo: Emprestimo

    // private itensDevolucao: ItemDevolucao[]
}
