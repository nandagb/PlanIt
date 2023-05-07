
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import entity.Tarefa;
import controller.TarefaController;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.*;

public class TarefaTest {
    public static Tarefa tarefa;

    @BeforeClass
    public static void setup(){
        String nome = "tarefa " + Tarefa.getUltimoId() + 1;
        String descricao = "Teste de criação de tarefa" + Tarefa.getUltimoId() + 1;
        String status = "em_andamento";
        Date prazo = new Date(2001,11,20);
        int project_id = 1;
        tarefa = new Tarefa(nome, descricao, status,prazo,project_id);
    }
    @Test
    public void CriaTarefaTest() throws SQLException {
        System.out.println("Criacao: " + tarefa.getId());
        boolean criacao = TarefaController.criarTarefa(tarefa);
        assertTrue(criacao);
    }

    @Test
    public void DeletaTarefaTest() throws SQLException {
        boolean delecao = TarefaController.deletarTarefa(this.tarefa);
        assertTrue(delecao);
    }
}


