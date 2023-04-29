package com.pds.planit.controller;

import com.pds.planit.dao.ProjetoDAOImpl;
import com.pds.planit.entity.Projeto;
import com.pds.planit.entity.Usuario;

import java.util.Arrays;

public class ProjetoController {
    public ProjetoDAOImpl projetoDAO;

    public void criarProjeto(Projeto projeto){
        projetoDAO.save(projeto);
    }

    public Projeto procurarProjetoNome(String nome){
        return projetoDAO.findByName(nome);
    }

    public Projeto procurarProjetoId(int id){
        return projetoDAO.findById(id);
    }

    public void addMembro(Projeto projeto, Usuario usuario) {
        if(projeto.getEquipe() != null) {
            Usuario[] newEquipe = Arrays.copyOf(projeto.getEquipe(), projeto.getEquipe().length + 1);
            newEquipe[newEquipe.length - 1] = usuario;
        }
        else {
            Usuario[] newEquipe = new Usuario[1];
            newEquipe[0] = usuario;
        }
    }
}
