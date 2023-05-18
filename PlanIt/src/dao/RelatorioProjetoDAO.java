package dao;

import entity.RelatorioProjeto;

import java.sql.SQLException;

public interface RelatorioProjetoDAO {
    public boolean save(RelatorioProjeto relatorio) throws SQLException;
}
