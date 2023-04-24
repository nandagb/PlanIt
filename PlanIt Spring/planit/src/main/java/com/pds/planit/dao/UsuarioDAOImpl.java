package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Usuario;
import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    private EntityManager entityManager;

    @Autowired
    public UsuarioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        entityManager.persist(usuario);

    }

    @Override
    public Usuario findById(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario findByEmail(String email) {
        return entityManager.find(Usuario.class, email);
    }
}
