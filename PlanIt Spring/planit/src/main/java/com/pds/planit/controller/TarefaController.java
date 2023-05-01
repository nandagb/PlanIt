package com.pds.planit.controller;

import com.pds.planit.dao.TarefaDAOImpl;
import com.pds.planit.entity.Tarefa;
import com.pds.planit.entity.Usuario;

import java.util.Arrays;

public class TarefaController {
    public TarefaDAOImpl tarefaDAO;

    public void criarTarefa(Tarefa tarefa){
        tarefaDAO.save(tarefa);
    }

    public void editarStatus(String status, Tarefa tarefa){
        tarefa.setStatus(status);
        tarefaDAO.edit(tarefa);
    }

    public void adicionarMembroEquipe(Usuario usuario, Tarefa tarefa){
        if(tarefa.getEquipe() != null) {
            Usuario[] newEquipe = Arrays.copyOf(tarefa.getEquipe(), tarefa.getEquipe().length + 1);
            newEquipe[newEquipe.length - 1] = usuario;
            tarefa.setEquipe(newEquipe);
        }
        else {
            Usuario[] newEquipe = new Usuario[1];
            newEquipe[0] = usuario;
            tarefa.setEquipe(newEquipe);
        }

    }
}
