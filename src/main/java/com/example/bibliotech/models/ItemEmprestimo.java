package com.example.bibliotech.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;

@Entity
public class ItemEmprestimo {
    
    
    public ItemEmprestimo(int id, Date dataDevolucao, Date dataPrevista) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
    }

    
    public ItemEmprestimo(Date dataDevolucao, Date dataPrevista) {
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
    }

    public ItemEmprestimo(Date dataDevolucao, Date dataPrevista, Emprestimo emprestimo, Livro livro) {
        this.dataDevolucao = dataDevolucao;
        this.dataPrevista = dataPrevista;
        this.emprestimo = emprestimo;
        this.livro = livro;
    }

    
    public ItemEmprestimo() {
        this.id = 0;
        this.dataDevolucao = new Date();
        this.dataPrevista = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date dataDevolucao;

    private Date dataPrevista;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro.id")
    private Livro livro = new Livro();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimo.id")
    private Emprestimo emprestimo = new Emprestimo();

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

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    // private emprestimo:Emprestimo

//   
    // private livro: Livro
}
