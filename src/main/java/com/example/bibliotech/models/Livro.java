package com.example.bibliotech.models;

import java.util.ArrayList;
import java.util.Date;
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
public class Livro {

    public Livro(int id, boolean disponivel, Date dataPrevista) {
        this.id = id;
        this.disponivel = disponivel;
        this.dataPrevista = dataPrevista;
    }

    public Livro(boolean disponivel, Date dataPrevista, Titulo titulo) {
        this.disponivel = disponivel;
        this.dataPrevista = dataPrevista;
        this.titulo = titulo;
    }

    public Livro() {
        this.id = 0;
        this.disponivel = true;
        this.dataPrevista = new Date();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean disponivel;

    private Date dataPrevista;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo.id")
    private Titulo titulo;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Reserva> reservas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<ItemEmprestimo> itensEmprestimo = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<ItemDevolucao> itensDevolucao = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<ItemEmprestimo> getItensEmprestimo() {
        return itensEmprestimo;
    }

    public void setItensEmprestimo(List<ItemEmprestimo> itensEmprestimo) {
        this.itensEmprestimo = itensEmprestimo;
    }

    public List<ItemDevolucao> getItensDevolucao() {
        return itensDevolucao;
    }

    public void setItensDevolucao(List<ItemDevolucao> itensDevolucao) {
        this.itensDevolucao = itensDevolucao;
    }


    // private topico: ITopico;

    // private titulo: Titulo;

    // private reservas: Reserva[]

    // private itensEmprestimo: ItemEmprestimo[]

    // private itensDevolucao: ItemDevolucao[]
}
