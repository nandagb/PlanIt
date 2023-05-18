package services;

import dao.ProjetoDAOImpl;
import dao.RelatorioProjetoDAOImpl;
import entity.Projeto;
import entity.RelatorioProjeto;

public class RelatorioProjetoServices {

    public static RelatorioProjeto validaRelatorioPesquisaId(int id){
        if(validaId(id) == true){
            RelatorioProjetoDAOImpl dao = new RelatorioProjetoDAOImpl();
            RelatorioProjeto relatorio = dao.getRelatorioById(id);
            return relatorio;
        }
        return new RelatorioProjeto(-1,0);
    }

    public static RelatorioProjeto validaRelatorioPesquisaProjetoId(int id_projeto){
        RelatorioProjetoDAOImpl dao = new RelatorioProjetoDAOImpl();
        RelatorioProjeto relatorio = dao.getRelatorioByProjetoId(id_projeto);
        return relatorio;
    }

    private static boolean validaId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }

    public static boolean validaAdicionarTarefa(int id_projeto){
        RelatorioProjetoDAOImpl dao = new RelatorioProjetoDAOImpl();
        RelatorioProjeto relatorio = dao.getRelatorioByProjetoId(id_projeto);
        relatorio.adicionarTarefa();
        return dao.updateRelatorioProjeto(relatorio);
    }
}
