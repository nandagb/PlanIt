package dao;

import entity.Tarefa;

import java.sql.SQLException;
import java.util.List;

public interface TarefaDAO {

    void save(Tarefa tarefa) throws SQLException;

    boolean existe(Tarefa tarefa);

    Tarefa findById(int id);

    Tarefa findByName(String name);

    List<Tarefa> findAll();

    void update(Tarefa tarefa);

    void delete(int id);
}