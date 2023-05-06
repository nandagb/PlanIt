package dao;

import entity.Tarefa;

import java.sql.SQLException;
import java.util.List;

public interface TarefaDAO {
    Tarefa findById(int id);

    Tarefa findByName(String name, int project_id);
//  SALVA UMA TAREFA NO BANCO DE DADOS.
    void save(Tarefa tarefa) throws SQLException;

//  VERIFICA SE UMA TAREFA DE MESMO ID JÁ EXISTE NO BANCO DE DADOS.
    boolean existe(Tarefa tarefa);

//  RETORNA UMA LISTA COM TODAS AS TAREFAS EM UM PROJETO.
    List<Tarefa> findAllOnProject(int project_id);

//  ATUALIZA A ENTRADA DE UMA TAREFA COM OS SEUS VALORES ATUAIS.
    void update(Tarefa tarefa);

//  DELETA A ENTRADA DE UMA TAREFA COM O ID PASSADO NO BANCO DE DADOS.
    void delete(int id);
}
