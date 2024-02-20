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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;

@Entity
public class Emprestimo {

    public Emprestimo(int idEmprestimo, Date dataEmprestimo, double multa) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
    }

    public Emprestimo(Date dataEmprestimo, double multa) {
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
    }

    public Emprestimo(Date dataEmprestimo, double multa, Aluno aluno, ArrayList<ItemEmprestimo> itensEmprestimo, Devolucao devolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
        this.aluno = aluno;
        this.itensEmprestimo = itensEmprestimo;
        this.devolucao = devolucao;
    }

    public Emprestimo(int idEmprestimo, Date dataEmprestimo, double multa, Aluno aluno, Devolucao devolucao) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.multa = multa;
        this.aluno = aluno;
        this.devolucao = devolucao;
    }

    public Emprestimo() {
        this.dataEmprestimo = new Date();
        this.multa = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmprestimo;

    private Date dataEmprestimo;

    private double multa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno.id")
    private Aluno aluno = new Aluno();

    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY, orphanRemoval = false, cascade = CascadeType.ALL)
    private List<ItemEmprestimo> itensEmprestimo = new ArrayList<>();


    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Devolucao devolucao;

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<ItemEmprestimo> getItensDevolucao() {
        return itensEmprestimo;
    }

    public void setItensDevolucao(List<ItemEmprestimo> itensEmprestimo) {
        this.itensEmprestimo = itensEmprestimo;
    }

    
    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
    // private aluno: Aluno

    // private itensEmprestimo: ItemEmprestimo[]

    // private devolucao: Devolucao
}
