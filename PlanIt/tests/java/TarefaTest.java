
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    public void UpdateTarefa(){
        tarefa.setNome("1234");
        boolean update = TarefaController.atualizarTarefa(tarefa);
        assertEquals("1234", tarefa.getNome());
    }
    @Test
    public void BuscaTarefaIdTest(){
        Tarefa achado = TarefaController.acharTarefaId(tarefa.getId());
        assertEquals(achado.getId(), tarefa.getId());
    }
    @Test
    public void BuscaTarefaNomeTeste(){
        Tarefa achado = TarefaController.acharTarefaNome(tarefa.getNome(), 1);
        assertEquals(tarefa.getId(), achado.getId());
    }
    @Test
    public void BuscaTodasTarefasTeste(){
        List<Tarefa> achados = TarefaController.acharTarefasProjeto(1);
        System.out.println("Tarefas do projeto " + TarefaController.acharTarefaId(tarefa.getProject_id()).getNome()
                + "\n");
        achados.forEach(tarefa -> System.out.println(tarefa.getNome()));
    }

    @Test
    public void DeletaTarefaTest() throws SQLException {
        boolean delecao = TarefaController.deletarTarefa(tarefa);
        assertTrue(delecao);
    }
}


