package com.pds.planit.entity;

import jakarta.persistence.*;

import java.util.Date;

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

    @Column(name="status")
    private String status;

    @Column(name="prazo")
    private Date prazo;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Projeto projeto;


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

    public String getStatus() {
        return status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    //define print method

}
