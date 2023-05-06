package controller;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;
import services.TarefaServices;

public class TarefaController {
    public static void criarTarefa(Tarefa tarefa){
        TarefaServices.validaTarefa(tarefa);
    }
}
