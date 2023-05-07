
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import entity.Tarefa;
import controller.TarefaController;

import static org.junit.Assert.*;

public class TarefaTest {
    private Tarefa tarefa;
    @Before
    public void setup(){
        String nome = "tarefa " + Tarefa.getNextId();
        String descricao = "Teste de criação de tarefa" + Tarefa.getNextId();
        String status = "em_andamento";
        Date prazo = new Date(2001,11,20);
        int project_id = 1;
        this.tarefa = new Tarefa(nome, descricao, status,prazo,project_id);
    }

    @Test
    public void CriaTarefaTest() throws SQLException {
        boolean criacao = TarefaController.criarTarefa(this.tarefa);
        assertTrue(criacao);
    }
}
