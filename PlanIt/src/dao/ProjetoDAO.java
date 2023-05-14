package dao;

import entity.Projeto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjetoDAO {
    public boolean save(Projeto projeto) throws SQLException;
    public boolean existe(Projeto projeto) throws SQLException;
    public ArrayList<Projeto> getAllProjetos() throws SQLException;
    public Projeto getProjetoById(int id) throws SQLException;
    public Projeto getProjetoByName(String name) throws SQLException;
    public boolean updateProjeto(Projeto projeto) throws SQLException;
    public boolean deleteProjeto(Projeto projeto) throws SQLException;
}
