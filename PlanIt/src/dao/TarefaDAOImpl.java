package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Tarefa;

import java.sql.*;

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
            statement.setBoolean(4, tarefa.getStatus());
            statement.setDate(5,tarefa.getPrazo());
            statement.setInt(6,1);
            statement.executeUpdate();

        }
    }

    public static void main(String[] args){
        Tarefa tarefa = new Tarefa();
        TarefaDAOImpl dao = new TarefaDAOImpl();
        try{
            dao.save(tarefa);
        }catch (SQLException e){
            System.out.println(e);
        }


    }
}
