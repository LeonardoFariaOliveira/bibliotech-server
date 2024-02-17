package com.example.bibliotech.models;

import com.example.bibliotech.interfaces.IRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"email"}))
public class Bibliotecario extends UserDecorator {

    public Bibliotecario(int id, String nome, String email, String senha, IRole _user) {
        super(_user);
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Bibliotecario(String nome, String email, String senha, IRole _user) {
        super(_user);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Bibliotecario( IRole _user) {
        super(_user);
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    public Bibliotecario() {
        super(new User());
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;

    private String email;

    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRole(){
        return this.user.getRole() + "- bibliotecario ";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
