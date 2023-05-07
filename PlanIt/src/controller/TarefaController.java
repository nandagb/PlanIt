package controller;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;
import services.TarefaServices;

import java.sql.SQLException;

public class TarefaController {
    public static boolean criarTarefa(Tarefa tarefa){
        TarefaDAO dao = new TarefaDAOImpl();
        boolean criacao = TarefaServices.validaTarefa(tarefa);
        if(criacao){
            return true;
        }
        return false;
    }
}
