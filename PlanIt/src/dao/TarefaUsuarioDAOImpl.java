package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Tarefa;
import entity.TarefaUsuario;
import entity.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class TarefaUsuarioDAOImpl implements TarefaUsuarioDAO{
    Connection con;
    public TarefaUsuarioDAOImpl() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "root", "V3r3@dor3sMYSQL");
        }
    }

    public boolean save(TarefaUsuario atribuir){
        String nf = "INSERT INTO tarefa_usuario (id_tarefa, id_usuario) VALUES (?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(nf);
            pst.setInt(1, atribuir.getTarefaId());
            pst.setInt(2, atribuir.getUsuarioId());
            int res = pst.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public ArrayList<Usuario> findAllParticipantes(int tarefa_id) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa_usuario WHERE  id_tarefa = ?");
        statement.setInt(1, tarefa_id);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Integer> ids_usuarios = new ArrayList<Integer>();
        while(resultSet.next()){
            int id = resultSet.getInt("id_usuario");
            ids_usuarios.add(id);
        }
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        for (int usuario :  ids_usuarios) {
            UsuarioDAOImpl dao = new UsuarioDAOImpl();
            Usuario achado = dao.getUsuarioById(usuario);
            usuarios.add(achado);
        }
        return usuarios;
    }

    public ArrayList<Tarefa> findAllTarefasAtribuidas(int usuario_id) throws SQLException{
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tarefa_usuario WHERE  id_usuario = ?");
        statement.setInt(1, usuario_id);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Integer> ids_tarefas = new ArrayList<Integer>();
        while(resultSet.next()){
            int id = resultSet.getInt("id_tarefa");
            ids_tarefas.add(id);
        }
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        for (int tarefa :  ids_tarefas) {
            TarefaDAOImpl dao = new TarefaDAOImpl();
            Tarefa achado = dao.findById(tarefa);
            tarefas.add(achado);
        }
        return tarefas;
    };

    public boolean existe(TarefaUsuario tarefa_atribuida){
        try {
            String existe = "SELECT * FROM tarefa_usuario WHERE id_tarefa = ? AND id_usuario = ?";
            PreparedStatement pst = con.prepareStatement(existe);
            pst.setInt(1, tarefa_atribuida.getTarefaId());
            pst.setInt(2, tarefa_atribuida.getUsuarioId());
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                if (res.getInt("id_usuario") == tarefa_atribuida.getUsuarioId()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }


    public boolean delete(TarefaUsuario participante_removido){
        String string = "DELETE FROM tarefa_usuario WHERE id_tarefa = ? AND id_usuario = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, participante_removido.getTarefaId());
            pst.setInt(2, participante_removido.getUsuarioId());

            int res = pst.executeUpdate();
            if(res == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
