package entity;

import java.sql.Date;

public class Tarefa {
    public int id;
    public String nome;
    public String descricao;
    public boolean status;
    public Date prazo;
    public int project_id;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tarefa(){
        this.id = 1;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
