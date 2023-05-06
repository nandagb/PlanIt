package services;

import entity.Tarefa;

import java.sql.Date;

public class TarefaServices {
    public static void validaTarefa(Tarefa tarefa){}

//  CHECA SE A DATA DO PRAZO É POSTERIOR A DATA ATUAL
    public boolean prazoValido(Tarefa tarefa){
        long timeStampAtual = System.currentTimeMillis();
        Date dataAtual = new Date(timeStampAtual);
        if(dataAtual.compareTo(tarefa.getPrazo()) <= 0){
            return true;
        }
        return false;
    }
}
