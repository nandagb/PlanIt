package dao;

import entity.RelatorioProjeto;

import java.sql.SQLException;

public interface RelatorioProjetoDAO {
    public boolean save(RelatorioProjeto relatorio) throws SQLException;
    public RelatorioProjeto getRelatorioById(int id);
    public boolean updateRelatorioProjeto(RelatorioProjeto relatorio);
    public RelatorioProjeto getRelatorioByProjetoId(Integer id_projeto);
}
