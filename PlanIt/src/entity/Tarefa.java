package entity;

import java.sql.Date;

public class Tarefa {
    public int id;
    public String nome;
    public String descricao;
    public String status;
    public Date prazo;
    public int project_id;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tarefa(int id){
        this.id = id;
    }
    public Tarefa(int id, String nome, String descricao, String status, Date prazo, int project_id){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.prazo = prazo;
        this.project_id = project_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

}
