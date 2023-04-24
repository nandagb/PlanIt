package com.pds.planit.controller;

import com.pds.planit.entity.Usuario;
import com.pds.planit.dao.UsuarioDAOImpl;

public class UsuarioController {
    public UsuarioDAOImpl usuarioDAO;

    public void criarUsuario(Usuario usuario){
        usuarioDAO.save(usuario);
    }
}
