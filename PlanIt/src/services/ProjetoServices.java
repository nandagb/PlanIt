package services;

import controller.ProjetoController;
import controller.TarefaController;
import dao.ProjetoDAOImpl;
import entity.Projeto;
import entity.Tarefa;

import java.sql.SQLException;

public class ProjetoServices {
    public static boolean validaProjetoCriacao(Projeto projeto){
        if(validaNome(projeto.getNome()) == true){
            ProjetoDAOImpl dao = new ProjetoDAOImpl();
            dao.save(projeto);
            return true;
        }
        return false;
    }

    public static Projeto validaProjetoPesquisaNome(String nome){
        if(validaNome(nome) == true){
            try{
                ProjetoDAOImpl dao = new ProjetoDAOImpl();
                Projeto projeto = dao.getProjetoByName(nome);
                return projeto;
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return new Projeto(-1,"");
    }

    public static Projeto validaProjetoPesquisaId(int id){
        if(validaId(id) == true){
            ProjetoDAOImpl dao = new ProjetoDAOImpl();
            Projeto projeto = dao.getProjetoById(id);
            return projeto;
        }
        return new Projeto(-1,"");
    }

    public static boolean validaDelecaoProjeto(Projeto projeto){
        ProjetoDAOImpl dao = new ProjetoDAOImpl();
        if(dao.deleteProjeto(projeto) == true){
            return true;
        }
        return false;
    }

    private static boolean validaNome(String nome){
        if(nome.trim().length() > 0){
            return true;
        }
        return false;
    }

    private static boolean validaId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }
}
