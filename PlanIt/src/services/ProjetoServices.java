package services;

import controller.ProjetoController;
import controller.TarefaController;
import dao.ProjetoDAOImpl;
import entity.Projeto;
import entity.Tarefa;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoServices {
    private ProjetoDAOImpl dao;

    public ProjetoServices(){
        this.dao = new ProjetoDAOImpl();
    }
    public boolean validaProjetoCriacao(Projeto projeto){
        if(validaNome(projeto.getNome()) == true){
            this.dao.save(projeto);
            return true;
        }
        return false;
    }

    public Projeto validaProjetoPesquisaNome(String nome){
        if(validaNome(nome) == true){
            try{
                Projeto projeto = this.dao.getProjetoByName(nome);
                return projeto;
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return new Projeto(-1,"");
    }

    public Projeto validaProjetoPesquisaId(int id){
        if(validaId(id) == true){
            Projeto projeto = this.dao.getProjetoById(id);
            return projeto;
        }
        return new Projeto(-1,"");
    }

    public boolean validaDelecaoProjeto(Projeto projeto){
        if(this.dao.deleteProjeto(projeto) == true){
            return true;
        }
        return false;
    }

    public ArrayList<Projeto> validaBuscaTodosProjetos(){
        ArrayList<Projeto> projetos = this.dao.getAllProjetos();
        return projetos;
    }

    private boolean validaNome(String nome){
        if(nome.trim().length() > 0){
            return true;
        }
        return false;
    }

    private boolean validaId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }
}
