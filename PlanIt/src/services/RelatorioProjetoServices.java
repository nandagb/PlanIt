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

    private static boolean validaId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }
}
