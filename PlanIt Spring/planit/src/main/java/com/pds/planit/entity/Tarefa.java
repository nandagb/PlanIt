package com.pds.planit.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tarefa")
public class Tarefa {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome = "";

    @Column(name="descricao")
    private String descricao;


    //define constructors
    public Tarefa() {
    }

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    //define getters and setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String email) {
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    //define print method

}
