package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void save(Usuario usuario);

    Usuario findById(int id);

    List<Usuario> findAll();

    Usuario findByEmail(String email);
}
