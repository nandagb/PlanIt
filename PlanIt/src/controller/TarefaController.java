package controller;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;
import entity.TarefaUsuario;
import entity.Usuario;
import services.TarefaServices;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public static boolean removerParticipanteTarefa(TarefaUsuario participante_removido){
        boolean delecao = TarefaServices.validaParticipanteRemocao(participante_removido);
        if(delecao){
            return true;
        }
        return false;
    }

    public static boolean adicionarParticipante(TarefaUsuario tarefa_atribuida){
        boolean atribuicao = TarefaServices.validaAtribuicao(tarefa_atribuida);
        if(atribuicao){
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

    public static ArrayList<Tarefa> acharTarefasProjeto(int idProjeto){
        ArrayList<Tarefa> achado = TarefaServices.validaAcharIdProjeto(idProjeto);
        return achado;
    }

    public static ArrayList<Usuario> acharParticipantesTarefa(int idTarefa){
        ArrayList<Usuario> achado = TarefaServices.validaAcharIdTarefa(idTarefa);
        return achado;
    }

    public static ArrayList<Tarefa> acharTarefasAtribuidas(int idUsuario){
        ArrayList<Tarefa> achado = TarefaServices.validaAcharIdUsuario(idUsuario);
        return achado;
    }

    public static void toggleConclusaoTarefa(Tarefa tarefa){
        if (tarefa.getStatus().equals("em_andamento")){
            tarefa.setStatus("finalizado");
        }else{
            tarefa.setStatus("em_andamento");
        }
        atualizarTarefa(tarefa);
    }
}
