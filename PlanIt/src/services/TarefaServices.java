package services;

import dao.TarefaDAO;
import dao.TarefaDAOImpl;
import dao.TarefaUsuarioDAO;
import dao.TarefaUsuarioDAOImpl;
import entity.Tarefa;
import entity.TarefaUsuario;
import entity.Usuario;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public static boolean validaAtribuicao(TarefaUsuario atribuir){
        TarefaUsuarioDAO dao = new TarefaUsuarioDAOImpl();
        try{
            if(dao.existe(atribuir)){
                System.out.println("Este participante já foi adicionado nesta tarefa!");
                return false;
            }
            else{
                dao.save(atribuir);
                return true;
            }

        }catch (SQLException e){
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

    public static ArrayList<Tarefa> validaAcharIdProjeto(int idProjeto){
        TarefaDAO dao = new TarefaDAOImpl();
        try{
            if(idValido(idProjeto)){
                ArrayList<Tarefa> achados = dao.findAllOnProject(idProjeto);
                return achados;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return new ArrayList();
    }

    public static ArrayList<Usuario> validaAcharIdTarefa(int idTarefa){
        TarefaUsuarioDAO dao = new TarefaUsuarioDAOImpl();
        try{
            if(idValido(idTarefa)){
                ArrayList<Usuario> achados = dao.findAllParticipantes(idTarefa);
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
        System.out.println("O Prazo Informado Não é Valido.");
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
        if(tarefa.getStatus().equals("em_andamento") || tarefa.getStatus().equals("finalizado") || tarefa.getStatus().equals("atrasado")){
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
