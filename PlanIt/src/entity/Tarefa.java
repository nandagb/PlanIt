package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Tarefa {
    private int id;
    private String nome;
    private String descricao;
    private String status;
    private Date prazo;
    private int project_id;

    private static int ultimoId = 0;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tarefa(){this.id = getNextId();}

    public Tarefa(int id){ this.id = id; }
    public Tarefa(int id, String nome, String descricao, String status, Date prazo, int project_id){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.prazo = prazo;
        this.project_id = project_id;
    }

    public Tarefa(String nome, String descricao, String status, Date prazo, int project_id){
        this.id = getNextId();
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

    public static int getNextId(){
        ultimoId ++;
        return ultimoId;
    }

    public static int getUltimoId() {
        return ultimoId;
    }
}
