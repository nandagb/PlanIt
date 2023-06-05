package tests;

import controller.TarefaController;
import entity.Tarefa;
import entity.Usuario;
import org.junit.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TarefaControllerTest {

    @Test
    public void criaTarefaTest(){
        Date prazo = new Date(2001,11,03);
        Tarefa tarefa = new Tarefa(2, "teste", "tarefa teste", "em_andamento", prazo, 1);
        boolean criadoTrue = TarefaController.criarTarefa(tarefa);
        Date prazo2 = new Date(2001,11,22223);
        Tarefa tarefa2 = new Tarefa(2, "teste", "tarefa teste", "em_andamento", prazo2, 1);
        boolean criadoFalse = TarefaController.criarTarefa(tarefa2);
        assertTrue(criadoTrue);
        assertFalse(criadoFalse);
    }

    @Test
    public void deletaTarefaTest(){
        Date prazo = new Date(2001,11,03);
        Tarefa tarefa = new Tarefa(2, "teste", "tarefa teste", "em_andamento", prazo, 1);
        boolean deletadoTrue = TarefaController.deletarTarefa(tarefa);
        Date prazo2 = new Date(2001,11,22223);
        Tarefa tarefa2 = new Tarefa(2, "teste", "tarefa teste", "em_andamento", prazo2, 1);
        boolean deletadoFalse = TarefaController.deletarTarefa(tarefa2);
        assertTrue(deletadoTrue);
        assertFalse(deletadoFalse);
    }

    @Test
    public void atualizaTarefaTest(){
        Date prazo = new Date(2001,11,03);
        Tarefa tarefa = new Tarefa(2, "testeAtualizado", "tarefa teste", "em_andamento", prazo, 1);
        boolean criadoTrue = TarefaController.atualizarTarefa(tarefa);
        Date prazo2 = new Date(2001,11,22223);
        Tarefa tarefa2 = new Tarefa(20, "teste", "tarefa teste", "em_andamento", prazo2, 1);
        boolean criadoFalse = TarefaController.deletarTarefa(tarefa2);
        assertTrue(criadoTrue);
        assertFalse(criadoFalse);
    }

    @Test
    public void acharTarefaIdTest(){
        Tarefa tarefaTrue = TarefaController.acharTarefaId(2);
        Tarefa tarefaFalse = TarefaController.acharTarefaId(20);
        assertEquals(tarefaTrue.getId(), 2);
        assertNotEquals(2, tarefaFalse.getId());
    }

    @Test
    public void acharTarefasProjetoTest(){
        ArrayList<Tarefa> tarefasTrue = TarefaController.acharTarefasProjeto(1);
        ArrayList<Tarefa> tarefasFalse = TarefaController.acharTarefasProjeto(3);
        assertEquals(tarefasFalse.size(), 0);
        assertNotSame(tarefasTrue.size(), 0);
    }

    @Test
    public void acharTarefaNomeTest(){
        Tarefa tarefaTrue = TarefaController.acharTarefaNome("testeAtualizado", 1);
        Tarefa tarefaFalse = TarefaController.acharTarefaNome("testeAtualizado2", 1);
        assertEquals(tarefaTrue.getNome(), "testeAtualizado");
        assertNotEquals(tarefaFalse.getNome(), "testeAtualizado2");
    }

    @Test
    public void acharParticipantesTarefaTest(){
        ArrayList<Usuario> participantesTrue = TarefaController.acharParticipantesTarefa(1);
        ArrayList<Usuario> participantesFalse = TarefaController.acharParticipantesTarefa(3);
        assertEquals(participantesFalse.size(), 0);
        assertNotSame(participantesTrue.size(), 0);
    }

    @Test
    public void acharTarefasAtribuidasTest(){
        ArrayList<Tarefa> tarefasTrue = TarefaController.acharTarefasAtribuidas(1);
        ArrayList<Tarefa> tarefasFalse = TarefaController.acharTarefasAtribuidas(2);
        assertEquals(tarefasFalse.size(), 0);
        assertNotSame(tarefasTrue.size(), 0);
    }

    @Test
    public void toggleConclusaoTarefaTest(){
        Date prazo = new Date(2001,11,03);
        Tarefa tarefaAndamento = new Tarefa(2, "testeAtualizado", "tarefa teste", "em_andamento", prazo, 1);
        Tarefa tarefaFinalizada = new Tarefa(2, "testeAtualizado", "tarefa teste", "finalizado", prazo, 2);
        TarefaController.toggleConclusaoTarefa(tarefaAndamento);
        TarefaController.toggleConclusaoTarefa(tarefaFinalizada);
        assertEquals(tarefaAndamento.getStatus(), "finalizado");
        assertEquals(tarefaFinalizada.getStatus(), "em_andamento");
    }

    @Test
    public void acharTodosUsuariosTest(){
        Date prazo = new Date(2001,11,03);
        Tarefa tarefaAndamento = new Tarefa(2, "testeAtualizado", "tarefa teste", "em_andamento", prazo, 1);
        Tarefa tarefaFinalizada = new Tarefa(2, "testeAtualizado", "tarefa teste", "finalizado", prazo, 2);
        TarefaController.toggleConclusaoTarefa(tarefaAndamento);
        TarefaController.toggleConclusaoTarefa(tarefaFinalizada);
        assertEquals(tarefaAndamento.getStatus(), "finalizado");
        assertEquals(tarefaFinalizada.getStatus(), "em_andamento");
    }
}
