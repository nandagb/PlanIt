package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ProjetoDAOImpl implements ProjetoDAO{

    private EntityManager entityManager;

    @Autowired
    public ProjetoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Projeto projeto) {
        entityManager.persist(projeto);

    }

    @Override
    public Projeto findById(int id) {
        return entityManager.find(Projeto.class, id);
    }

    @Override
    public Projeto findByName(String nome) {
        return entityManager.find(Projeto.class, nome);
    }
}
