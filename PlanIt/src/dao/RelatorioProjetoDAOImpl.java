package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Projeto;
import entity.Relatorio;
import entity.RelatorioProjeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioProjetoDAOImpl {
    Connection con;
    public RelatorioProjetoDAOImpl() {
        if (con == null) {
            con = new DBConnection().getConnection(DBDriver.MYSQL, "planit", "root", "V3r3@dor3sMYSQL");
        }
    }
    public boolean save(RelatorioProjeto relatorio) {
        String nf = "INSERT INTO relatorioprojeto (id, id_projeto) VALUES (?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(nf);

            PreparedStatement statement = con.prepareStatement("SELECT next_id_relatorioprojeto FROM ids");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id_relatorio = resultSet.getInt("next_id_relatorioprojeto");
                relatorio.setUltimoId(id_relatorio);
            } else {
                // Se não houver registro, define o próximo ID como 0
                relatorio.setUltimoId(0);
            }


            pst.setInt(1, relatorio.getNextId());
            System.out.println("");
            statement.executeUpdate("UPDATE ids SET next_id_relatorioprojeto = " + relatorio.getUltimoId());
            pst.setInt(2, relatorio.getIdProjeto());

            int res = pst.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
