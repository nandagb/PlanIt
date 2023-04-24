package com.pds.planit.controller;


import com.pds.planit.dao.TarefaDAOImpl;
import com.pds.planit.entity.Tarefa;

public class TarefaController {
    public TarefaDAOImpl tarefaDAO;

    public void criarTarefa(Tarefa tarefa){
        tarefaDAO.save(tarefa);
    }
}
