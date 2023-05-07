package services;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import entity.Tarefa;

import java.sql.Date;
import java.sql.SQLException;

public class TarefaServices {
    public static boolean validaTarefaCriacao(Tarefa tarefa){
        if(prazoValido(tarefa) && nomeValido(tarefa) && statusValido(tarefa)){
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
    public static boolean nomeValido(Tarefa tarefa){
        if(tarefa.getNome().length() > 0){
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
}
