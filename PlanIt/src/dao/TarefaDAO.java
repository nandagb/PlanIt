package dao;

import entity.Tarefa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TarefaDAO {
    Tarefa findById(int id) throws SQLException;

    Tarefa findByName(String name, int project_id) throws SQLException;
//  SALVA UMA TAREFA NO BANCO DE DADOS.
    void save(Tarefa tarefa) throws SQLException;

//  VERIFICA SE UMA TAREFA DE MESMO ID JÁ EXISTE NO BANCO DE DADOS.
    boolean existe(Tarefa tarefa) throws SQLException;

//  RETORNA UMA LISTA COM TODAS AS TAREFAS EM UM PROJETO.
    ArrayList<Tarefa> findAllOnProject(int project_id) throws SQLException;

//  ATUALIZA A ENTRADA DE UMA TAREFA COM OS SEUS VALORES ATUAIS.
    void update(Tarefa tarefa) throws SQLException;

//  DELETA A ENTRADA DE UMA TAREFA COM O ID PASSADO NO BANCO DE DADOS.
    void delete(int id) throws SQLException;
}
