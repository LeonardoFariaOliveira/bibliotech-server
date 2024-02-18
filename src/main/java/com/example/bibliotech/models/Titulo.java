package com.example.bibliotech.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;

@Entity
public class Titulo {

    public Titulo(int id, String nome, int prazo, String isbn, int edicao, int ano) {
        this.id = id;
        this.nome = nome;
        this.prazo = prazo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
    }

    public Titulo(String nome, int prazo, String isbn, int edicao, int ano, Area area) {
        this.nome = nome;
        this.prazo = prazo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
        this.area = area;
    }

    public Titulo(String nome, int prazo, String isbn, int edicao, int ano, Area area, Autor autor) {
        this.nome = nome;
        this.prazo = prazo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
        this.area = area;
        this.autor = autor;
    }   

    public Titulo(String nome, int prazo, String isbn, int edicao, int ano) {
        this.nome = nome;
        this.prazo = prazo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.ano = ano;
    }

    public Titulo() {
        this.id = 0;
        this.nome = "";
        this.prazo = 0;
        this.isbn = "";
        this.edicao = 0;
        this.ano = 0;
    }
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private int prazo;

    private String isbn;

    private int edicao;

    private int ano;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "area.id")
    private Area area = new Area();
    
    @JsonIgnore
    @OneToMany(mappedBy = "titulo", orphanRemoval = false)
    private List<Livro> livros = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor.id")
    private Autor autor = new Autor();

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

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
