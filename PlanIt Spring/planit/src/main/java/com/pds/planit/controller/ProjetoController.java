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
//    ADICIONA MEMBRO A EQUIPE
    public void addMembro(Projeto projeto, Usuario usuario) {
        if(projeto.getEquipe() != null) {
            Usuario[] newEquipe = Arrays.copyOf(projeto.getEquipe(), projeto.getEquipe().length + 1);
            newEquipe[newEquipe.length - 1] = usuario;
            projeto.setEquipe(newEquipe);
        }
        else {
            Usuario[] newEquipe = new Usuario[1];
            newEquipe[0] = usuario;
            projeto.setEquipe(newEquipe);
        }
    }
    //	REMOVE MEMBRO DA EQUIPE
    public void removeMembro(Projeto projeto, Usuario usuario) {
        int indice_usuario = -1;
        for(int i = 0; i < projeto.getEquipe().length; i++) {
            if(projeto.getEquipe()[i] == usuario) {
                indice_usuario = i;
            }
        }

        Usuario[] newEquipe = new Usuario[projeto.getEquipe().length - 1];
        for(int i = 0, j =0; i < newEquipe.length; i ++) {
            if(i != indice_usuario) {
                newEquipe[j++] = projeto.getEquipe()[i];
            }
        }
        projeto.setEquipe(newEquipe);
    }
}
