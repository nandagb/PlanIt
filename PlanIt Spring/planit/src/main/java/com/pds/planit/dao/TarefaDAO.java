package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Tarefa;

public interface TarefaDAO {

    void save(Tarefa tarefa);

    Tarefa findById(int id);

    Tarefa findByName(String name);
}
