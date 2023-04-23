package com.pds.planit.dao;

import com.pds.planit.entity.Tarefa;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TarefaDAOImpl implements TarefaDAO{

    private EntityManager entityManager;

    @Autowired
    public TarefaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Tarefa tarefa) {
        entityManager.persist(tarefa);

    }
}
