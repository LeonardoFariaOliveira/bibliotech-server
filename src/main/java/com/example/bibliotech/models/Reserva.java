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
public class Reserva {

    public Reserva(int id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Reserva(Date data) {
        this.data = data;
    }

    public Reserva(Date data, Livro livro, Aluno aluno) {
        this.data = data;
        this.livro = livro;
        this.aluno = aluno;
    }

    public Reserva() {
        this.id = 0;
        this.data = new Date();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno.id")
    private Aluno aluno = new Aluno();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro.id")
    private Livro livro = new Livro();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    // private aluno:Aluno

    // private livro:Livro
}
