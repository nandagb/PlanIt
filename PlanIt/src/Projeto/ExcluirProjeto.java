package Projeto;

import java.util.Scanner;

public class ExcluirProjeto implements Menu {

	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		ProjetoController controlador = new ProjetoController();
		System.out.println("Insira o ID do Projeto:");
		int opcao = scanner.nextInt();
		Projeto projeto = controlador.pesquisarProjeto(opcao);
		receberEntrada(opcao, projeto);
	}
	
	public void receberEntrada(int opcao, Projeto projeto) {
		ProjetoController controlador = new ProjetoController();
		if(projeto != null) {
			try {
				controlador.excluirProjeto(projeto);
			}catch(Exception e) {
				System.out.println("Ocorreu um erro ao excluir o projeto.");
			}
			System.out.println("Projeto \"" + projeto.getNome() + "\" excluído com sucesso!");
		}
		else {
			System.out.println("O projeto não foi encontrado.");
		}
		Menu menuPrincipal = new MenuPrincipal();
		menuPrincipal.exibirConteudo();
	}
	
	public void receberEntrada(String opcao, Projeto projeto) {
		
	}
}
