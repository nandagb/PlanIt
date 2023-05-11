package services;

import controller.ProjetoController;
import controller.TarefaController;
import dao.ProjetoDAOImpl;
import entity.Projeto;
import entity.Tarefa;

public class ProjetoServices {
    public static boolean validaProjetoCriacao(Projeto projeto){
        if(validaNome(projeto.getNome()) == true){
            ProjetoDAOImpl dao = new ProjetoDAOImpl();
            dao.save(projeto);
            return true;
        }
        return false;
    }

    private static boolean validaNome(String nome){
        if(nome.trim().length() > 0){
            return true;
        }
        return false;
    }
}
