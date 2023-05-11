package services;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaServices {
    public static boolean validaTarefaCriacao(Tarefa tarefa){
        if(prazoValido(tarefa) && nomeValido(tarefa.getNome()) && statusValido(tarefa)){
            try {
                TarefaDAO dao = new TarefaDAOImpl();
                dao.save(tarefa);
                return true;
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public static boolean validaTarefaDelecao(Tarefa tarefa){
        TarefaDAO dao = new TarefaDAOImpl();
        try{
            if(dao.existe(tarefa)){
                dao.delete(tarefa.getId());
                return true;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean validaTarefaAtt(Tarefa tarefa){
        if(prazoValido(tarefa) && nomeValido(tarefa.getNome()) && statusValido(tarefa)){
            try {
                TarefaDAO dao = new TarefaDAOImpl();
                dao.update(tarefa);
                return true;
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }

    public static Tarefa validaAcharId(int id){
        TarefaDAO dao = new TarefaDAOImpl();
        try{
            if(idValido(id)){
                Tarefa achado = dao.findById(id);
                return achado;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return new Tarefa(-1);
    }

    public static Tarefa validaAcharNome(String nome, int idProjeto){
        TarefaDAO dao = new TarefaDAOImpl();
        try{
            if(nomeValido(nome)){
                Tarefa achado = dao.findByName(nome, idProjeto);
                return achado;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return new Tarefa(-1);
    }

    public static List validaAcharIdProjeto(int idProjeto){
        TarefaDAO dao = new TarefaDAOImpl();
        try{
            if(idValido(idProjeto)){
                List achados = dao.findAllOnProject(idProjeto);
                return achados;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return new ArrayList();
    }

//  CHECA SE A DATA DO PRAZO É POSTERIOR A DATA ATUAL
    public static boolean prazoValido(Tarefa tarefa){
        long timeStampAtual = System.currentTimeMillis();
        Date dataAtual = new Date(timeStampAtual);
        if(dataAtual.compareTo(tarefa.getPrazo()) <= 0){
            return true;
        }
        return false;
    }

//    VERIFICA SE O NOME É VÁLIDO
    public static boolean nomeValido(String nome){
        if(nome.length() > 0){
            return true;
        }
        return false;
    }

//    CHECA SE O STATUS PASSADO É VÁLIDO
    public static boolean statusValido(Tarefa tarefa){
        if(tarefa.getStatus() == "em_andamento" || tarefa.getStatus() == "finalizado" || tarefa.getStatus() == "atrasado"){
            return true;
        }
        return false;
    }

    public static boolean idValido(int id){
        if (id >= 1){
            return true;
        }
        return false;
    }
}
