package com.pds.planit.controller;

import com.pds.planit.dao.ProjetoDAOImpl;
import com.pds.planit.entity.Projeto;

public class ProjetoController {
    public ProjetoDAOImpl projetoDAO;

    public void criarProjeto(Projeto projeto){
        projetoDAO.save(projeto);
    }

    public Projeto procurarProjetoNome(String nome){
        return projetoDAO.findByName(nome);
    }

    public Projeto procurarProjetoId(int id){
        return projetoDAO.findByID(id);
    }
}
