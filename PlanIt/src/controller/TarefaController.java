package controller;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;
import services.TarefaServices;

import java.sql.SQLException;

public class TarefaController {
    public static boolean criarTarefa(Tarefa tarefa){
        TarefaDAO dao = new TarefaDAOImpl();
        boolean criacao = TarefaServices.validaTarefaCriacao(tarefa);
        if(criacao){
            return true;
        }
        return false;
    }

    public static boolean deletarTarefa(Tarefa tarefa){
        TarefaDAO dao = new TarefaDAOImpl();
        boolean delecao = TarefaServices.validaTarefaDelecao(tarefa);
        if(delecao){
            return true;
        }
        return false;
    }
}
