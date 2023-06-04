package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Projeto;
import entity.RelatorioProjeto;
import entity.Tarefa;

import java.sql.*;
import java.util.ArrayList;

public class ProjetoDAOImpl implements ProjetoDAO {
    Connection con;

    public ProjetoDAOImpl() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "ezequiel", "");
        }
    }

    public boolean save(Projeto projeto) {
        if(existe(projeto)){
            return false;
        } else {
            String nf = "INSERT INTO projeto (id, nome, andamento) VALUES (?,?,?)";
            PreparedStatement pst;
            try {
                pst = con.prepareStatement(nf);

                PreparedStatement statement = con.prepareStatement("SELECT next_id_projeto FROM ids");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int id_projeto = resultSet.getInt("next_id_projeto");
                    projeto.setUltimoId(id_projeto);
                } else {
                    // Se não houver registro, define o próximo ID como 0
                    projeto.setUltimoId(0);
                }

                
                pst.setInt(1, projeto.getNextId());
                statement.executeUpdate("UPDATE ids SET next_id_projeto = " + projeto.getUltimoId());

                RelatorioProjeto relatorio = new RelatorioProjeto(projeto.getUltimoId());
                RelatorioProjetoDAOImpl daoRelatorio = new RelatorioProjetoDAOImpl();


                pst.setString(2, projeto.getNome());
                pst.setFloat(3, projeto.getAndamento());

                int res = pst.executeUpdate();
                daoRelatorio.save(relatorio);
                if (res == 1) {
                    return true;
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean existe(Projeto projeto) {
        try {
            String existe = "SELECT nome FROM projeto WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(existe);
            pst.setString(1, projeto.getNome());
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                if (res.getString("nome") == projeto.getNome()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }


    public ArrayList<Projeto> getAllProjetos() {
        String todos = "SELECT * FROM projeto";
        PreparedStatement ps;
        ArrayList<Projeto> projetos = new ArrayList<>();
        try {
            ps = con.prepareStatement(todos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Projeto a = new Projeto(rs.getInt("id"), rs.getString("nome"));
                a.setAndamento(rs.getFloat("andamento"));
                projetos.add(a);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return projetos;
    }



    public Projeto getProjetoById(int id) {
        String projeto = "SELECT * FROM projeto";

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(projeto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Projeto a = new Projeto(rs.getInt("id"), rs.getString("nome"));
                a.setAndamento(rs.getFloat("andamento"));
                if(a.getId() == id) {
                    return a;
                }

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;
    }

    public Projeto getProjetoByName(String name) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM projeto WHERE nome = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            Projeto projeto = new Projeto(id, nome);
            return projeto;
        }
        return new Projeto(-1, "");
    }



    public boolean updateProjeto(Projeto projeto) {
        String string = "UPDATE projeto SET nome = ?, andamento = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setString(1, projeto.getNome());
            pst.setFloat(2, projeto.getAndamento());
            pst.setInt(3, projeto.getId());
            int res = pst.executeUpdate();
            if(res == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public boolean deleteProjeto(Projeto projeto) {
        String string = "DELETE FROM projeto WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, projeto.getId());
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