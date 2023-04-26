package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Projeto> findAll() {
        TypedQuery<Projeto> query = entityManager.createQuery("FROM Projeto", Projeto.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Projeto projeto) {
        entityManager.merge(projeto);
    }

    @Override
    public void delelete(int id) {
        Projeto projeto = entityManager.find(Projeto.class, id);

        entityManager.remove(projeto);
    }
}
