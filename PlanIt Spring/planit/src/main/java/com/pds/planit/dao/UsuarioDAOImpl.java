package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Usuario;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario", Usuario.class);
        return query.getResultList();
    }


    @Override
    public List<Usuario> findByEmail(String email) {

        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE email=:dado", Usuario.class);
        query.setParameter("dado", email);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        entityManager.remove(usuario);
    }
}
