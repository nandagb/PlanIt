package dao;

import db.DBConnection;
import db.DBDriver;
import entity.Projeto;
import entity.Relatorio;
import entity.RelatorioProjeto;
import entity.Usuario;

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

    public RelatorioProjeto getRelatorioById(int id) {
        String projeto = "SELECT * FROM relatorioprojeto";

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(projeto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RelatorioProjeto a = new RelatorioProjeto(rs.getInt("id"), 0);
                if(a.getId() == id) {
                    return a;
                }

            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;
    }


    public boolean updateRelatorioProjeto(RelatorioProjeto relatorio) {
        String string = "UPDATE relatorioprojeto SET ntarefas = ?, ntarefas_concluidas = ?, porcentagem_concluido = ?, tmedio_tarefa = ?, tarefas_atrasadas = ?, ntarefas_sem_usuario = ? WHERE id = ?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(string);
            pst.setInt(1, relatorio.getNTarefas());
            pst.setInt(2, relatorio.getNTarefasConcluidas());
            pst.setFloat(3, relatorio.getPorcentagemConcluido());
            pst.setFloat(4, relatorio.getTmedioTarefa());
            pst.setInt(5, relatorio.getTarefasAtrasadas());
            pst.setInt(6, relatorio.getNTarefasSemUsuario());
            pst.setInt(7, relatorio.getId());
            int res = pst.executeUpdate();
            if(res == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public RelatorioProjeto getRelatorioByProjetoId(Integer id_projeto) {

        String relatorio = "SELECT * FROM relatorioprojeto";

        PreparedStatement ps;

        try {
            ps = con.prepareStatement(relatorio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RelatorioProjeto a = new RelatorioProjeto();
                System.out.println("ntarefas: " + rs.getInt("ntarefas"));
                a.setNTarefas(rs.getInt("ntarefas"));
                a.setNTarefasConcluidas(rs.getInt("ntarefas_concluidas"));
                a.setPorcentagemConcluido(rs.getFloat("porcentagem_concluido"));
                a.setTmedioTarefa(rs.getFloat("tmedio_tarefa"));
                a.setTarefasAtrasadas(rs.getInt("tarefas_atrasadas"));
                a.setNTarefasSemUsuario(rs.getInt("ntarefas_sem_usuario"));
                a.setProjetoI(rs.getInt("id_projeto"));
                a.setId(rs.getInt("id"));

                if(a.getIdProjeto() == id_projeto) {
                    return a;
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return null;
    }
}
