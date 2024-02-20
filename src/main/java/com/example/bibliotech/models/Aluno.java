package com.example.bibliotech.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Entity;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"cpf"}))
public class Aluno {

    public Aluno(int matricula, String nome, String cpf, String endereco) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Aluno(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Aluno() {
        this.matricula = 0;
        this.nome = "";
        this.cpf = "";
        this.endereco = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricula;

    private String nome;

    private String cpf;

    private String endereco;

 
    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Debito> debitos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Reserva> reservas = new ArrayList<>();

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Debito> getDebitos() {
        return debitos;
    }

    public void setDebitos(List<Debito> debitos) {
        this.debitos = debitos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }


    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }


    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
 


}
