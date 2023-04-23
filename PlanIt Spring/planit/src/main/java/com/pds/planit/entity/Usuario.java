package com.pds.planit.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome = "";

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    //define constructors
    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //define getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    //define print method
    public void printUsuario() {
        String usuario = "Usuario{" +
                "id=" + this.id +
                ", nome='" + this.nome + '\'' +
                ", email='" + this.email + '\'' +
                '}';
        System.out.println(usuario);
    }
}
