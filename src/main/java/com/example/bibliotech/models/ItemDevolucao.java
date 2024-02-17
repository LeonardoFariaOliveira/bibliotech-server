package com.example.bibliotech.models;

import java.util.Date;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;

@Entity
public class ItemDevolucao {

    public ItemDevolucao(int id, Date dataDevolucao, double valor, double multa, int diasAtraso) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.multa = multa;
        this.diasAtraso = diasAtraso;
    }

    public ItemDevolucao(Date dataDevolucao, double valor, double multa, int diasAtraso) {
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
        this.multa = multa;
        this.diasAtraso = diasAtraso;
    }

    public ItemDevolucao() {
        this.id = 0;
        this.dataDevolucao = new Date();
        this.valor = 0;
        this.multa = 0;
        this.diasAtraso = 0;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dataDevolucao;

    private double valor;

    private double multa;

    private int diasAtraso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro.id")
    private Livro livro = new Livro();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devolucao.id")
    private Devolucao devolucao = new Devolucao();

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    // private devolucao: Devolucao

    // private livro: Livro
}
