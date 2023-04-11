package Projeto;

import java.util.Scanner;

public class CriarProjeto implements Menu {
	
	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o Nome do Projeto:");
		String opcao = scanner.nextLine();
		Projeto projeto = new Projeto(0, opcao);
		receberEntrada(opcao, projeto);
	}
	
	@Override
	public void receberEntrada(String opcao, Projeto projeto) {
		ProjetoController controlador = new ProjetoController();
		projeto.setNome(opcao);
		controlador.addProjeto(0, opcao);
		System.out.println("Projeto " + opcao + " criado com sucesso!");
		
	}

	@Override
	public void receberEntrada(int opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}
}
