package com.example.bibliotech.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"name"}))
public class Autor {

    public Autor(int id, String nome, String sobrenome, String titulacao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulacao = titulacao;
    }

    public Autor(String nome, String sobrenome, String titulacao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulacao = titulacao;
    }

    public Autor(String nome, String sobrenome, String titulacao, ArrayList<Titulo> titulos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.titulacao = titulacao;
        this.titulos = titulos;
    }

    public Autor() {
        this.id = 0;
        this.nome = "";
        this.sobrenome = "";
        this.titulacao = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String sobrenome;

    private String titulacao;

    @Column(nullable=true) 
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY )
    private List<Titulo> titulos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }

}
