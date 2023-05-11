package controller;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;
import services.TarefaServices;

import java.sql.SQLException;
import java.util.List;

public class TarefaController {
    public static boolean criarTarefa(Tarefa tarefa){
        boolean criacao = TarefaServices.validaTarefaCriacao(tarefa);
        if(criacao){
            return true;
        }
        return false;
    }

    public static boolean deletarTarefa(Tarefa tarefa){
        boolean delecao = TarefaServices.validaTarefaDelecao(tarefa);
        if(delecao){
            return true;
        }
        return false;
    }

    public static boolean atualizarTarefa(Tarefa tarefa){
        boolean att = TarefaServices.validaTarefaAtt(tarefa);
        if(att){
            return true;
        }
        return false;
    }

    public static Tarefa acharTarefaId(int id){
        Tarefa achado = TarefaServices.validaAcharId(id);
        return achado;
    }

    public static Tarefa acharTarefaNome(String nome, int idProjeto){
        Tarefa achado = TarefaServices.validaAcharNome(nome, idProjeto);
        return achado;
    }

    public static List acharTarefasProjeto(int idProjeto){
        List achado = TarefaServices.validaAcharIdProjeto(idProjeto);
        return achado;
    }
}
