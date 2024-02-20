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
public class Debito {
    
    public Debito(int id, double valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }

    public Debito(double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    public Debito(double valor, Date data, Aluno aluno) {
        this.valor = valor;
        this.data = data;
        this.aluno = aluno;
    }

    public Debito() {
        this.id = 0;
        this.valor = 0.0;
        this.data = new Date();
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double valor;

    private Date data;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno.id")
    private Aluno aluno = new Aluno();


    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
