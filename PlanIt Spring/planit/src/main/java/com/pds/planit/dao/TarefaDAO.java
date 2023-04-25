package com.pds.planit.dao;

import com.pds.planit.entity.Tarefa;


import java.util.List;

public interface TarefaDAO {

    void save(Tarefa tarefa);

    Tarefa findById(int id);

    Tarefa findByName(String name);

    List<Tarefa> findAll();
}
