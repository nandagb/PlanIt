package com.pds.planit.dao;

import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Usuario;

public interface UsuarioDAO {

    void save(Usuario usuario);

    Usuario findById(int id);

    Usuario findByEmail(String email);
}
