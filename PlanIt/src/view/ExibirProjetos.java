package view;

import controller.ProjetoController;
import entity.Projeto;

public class ExibirProjetos implements Menu {
	public void exibirConteudo() {		
		ProjetoController controlador = new ProjetoController();
		controlador.listarProjetos();
	}

	@Override
	public void receberEntrada(int opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberEntrada(String opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}
}
