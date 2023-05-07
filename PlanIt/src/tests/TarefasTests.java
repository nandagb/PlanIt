package tests;
import entity.Tarefa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TarefasTests {
    @BeforeEach
    void setup(){
        Tarefa tarefa = new Tarefa();
    }

    @Test
    void CriaTarefaTest(){

    }
}
