package Projeto;

import java.util.Scanner;

public class CriarProjeto implements Menu {
	
	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o Nome do Projeto:");
		String nome = scanner.nextLine();
		System.out.println("Insira o id do Projeto:");
		int id = scanner.nextInt();
		Projeto projeto = new Projeto(id, nome);
		receberEntrada(nome, projeto);
	}
	
	@Override
	public void receberEntrada(String opcao, Projeto projeto) {
		ProjetoController controlador = new ProjetoController();
		projeto.setNome(opcao);
		controlador.addProjeto(projeto.getId(), opcao);
		System.out.println("Projeto " + opcao + " criado com sucesso!");
		
	}

	@Override
	public void receberEntrada(int opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}
}
