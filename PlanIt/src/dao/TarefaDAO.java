package dao;

import entity.Tarefa;

import java.sql.SQLException;
import java.util.List;

public interface TarefaDAO {

    void save(Tarefa tarefa) throws SQLException;

    boolean existe(Tarefa tarefa);

    Tarefa findById(int id);

    Tarefa findByName(String name, int project_id);

    List<Tarefa> findAllOnProject(int project_id);

    void update(Tarefa tarefa);

    void delete(int id);
}
