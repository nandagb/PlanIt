package controller;

import dao.RelatorioProjetoDAOImpl;
import entity.Projeto;
import entity.RelatorioProjeto;
import services.ProjetoServices;
import services.RelatorioProjetoServices;

public class RelatorioProjetoController {
    private RelatorioProjetoDAOImpl relatorios;

    public RelatorioProjetoController(){
        relatorios = new RelatorioProjetoDAOImpl();
    }

    public static RelatorioProjeto pesquisarRelatorioId(int id) {
        RelatorioProjeto relatorio = RelatorioProjetoServices.validaRelatorioPesquisaId(id);
        return relatorio;
    }
}
