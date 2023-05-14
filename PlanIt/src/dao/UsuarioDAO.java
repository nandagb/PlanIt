package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UsuarioDAO {
    public boolean save(Usuario usuario) throws SQLException;
    public boolean existe(Usuario usuario) throws SQLException;
    public boolean emailEmUso(Usuario usuario) throws SQLException;
    public ArrayList<Usuario> getAllUsuarios() throws SQLException;
    public Usuario getUsuarioById(int id) throws SQLException;
    public Usuario getUsuarioByEmail(String email) throws SQLException;
    public boolean updateUsuario(Usuario usuario) throws SQLException;
    public boolean deleteUsuario(Usuario usuario) throws SQLException;

}
