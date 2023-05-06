package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Tarefa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAOImpl{
    Connection con;

    public TarefaDAOImpl(){
        if(con == null){
            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "ezequiel", "");
        }
    }

    public boolean existe(Tarefa tarefa) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa WHERE id = ?");
        statement.setString(1, String.valueOf(tarefa.getId()));
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return true;
        };
        return false;
    }

    public void save(Tarefa tarefa) throws SQLException {
        if(!existe(tarefa)){
            PreparedStatement statement = con.prepareStatement("INSERT INTO tarefa " +
                    "(id,nome,descricao, status, prazo, project_id) VALUES (?,?,?,?,?,?)");
            statement.setInt(1, tarefa.getId());
            statement.setString(2, tarefa.getNome());
            statement.setString(3, tarefa.getDescricao());
            statement.setString(4, tarefa.getStatus());
            statement.setDate(5,tarefa.getPrazo());
            statement.setInt(6,tarefa.getProject_id());
            statement.executeUpdate();
        }
    }

    public Tarefa findByName(String name, int id_projeto) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa WHERE nome = ? AND project_id = ?");
        statement.setString(1, name);
        statement.setInt(2, id_projeto);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            String status = resultSet.getString("status");
            Date data = resultSet.getDate("prazo");
            int project_id = resultSet.getInt("project_id");
            Tarefa newTarefa = new Tarefa(id, nome, descricao, status, data, project_id);
            return newTarefa;
        }
        return new Tarefa(-1);
    }

    public Tarefa findById(int id) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            String status = resultSet.getString("status");
            Date data = resultSet.getDate("prazo");
            int project_id = resultSet.getInt("project_id");
            Tarefa newTarefa = new Tarefa(id, nome, descricao, status, data, project_id);
            return newTarefa;
        }
        return new Tarefa(-1);
    }

    public List<Tarefa> findAllonProject(int project_id) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa WHERE project_id = ?");
        statement.setInt(1, project_id);
        ResultSet resultSet = statement.executeQuery();
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");
            String status = resultSet.getString("status");
            Date data = resultSet.getDate("prazo");
            Tarefa newTarefa = new Tarefa(id, nome, descricao, status, data, project_id);
            tarefas.add(newTarefa);
        }
        return tarefas;
    };

    public static void main(String[] args){
        Tarefa tarefa = new Tarefa(1);
        TarefaDAOImpl dao = new TarefaDAOImpl();
        try{
            for (Tarefa tarefaTeste:
                 dao.findAllonProject(1)) {
                    System.out.println(tarefaTeste.nome);
            }
        }catch (SQLException e){
            System.out.println(e);
        }


    }
}
