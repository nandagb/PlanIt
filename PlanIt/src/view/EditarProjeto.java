package view;

import controller.MenuPrincipal;
import controller.ProjetoController;
import entity.Projeto;

import java.util.Scanner;

public class EditarProjeto implements Menu {
	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		ProjetoController controlador = new ProjetoController();
		System.out.println("Informe o Id do projeto.");
		int opcao = scanner.nextInt();
		Projeto projeto = controlador.pesquisarProjeto(opcao);
		receberEntrada(opcao, projeto);
	}
	
	public void receberEntrada(int opcao, Projeto projeto) {
		Scanner scanner = new Scanner(System.in);
		ProjetoController controlador = new ProjetoController();
		System.out.println("\n\n [1] Mudar Id \n [2] Editar Nome");
		int opcaoEdicao = scanner.nextInt();
		if(opcaoEdicao == 1) {
			System.out.println("Informe um novo Id:");
			int novoId = scanner.nextInt();
			Projeto novoProjeto = new Projeto(novoId, projeto.getNome());
		}
		else if(opcaoEdicao == 2) {
			scanner.nextLine();
			System.out.println("Informe um novo nome:");
			String novoNome = scanner.nextLine();
			Projeto novoProjeto = new Projeto(projeto.getId(), novoNome);
			if(controlador.editarProjeto(novoProjeto)) {
				System.out.println("Projeto: " + projeto.getId() + " foi editado com sucesso!");
			}	
			else {
				System.out.println("Não foi possível editar o projeto!");
			}
			
		}
		else {
			System.out.println("Não foi inserido uma opção válida");
			Menu menu = new MenuPrincipal();
			menu.exibirConteudo();
		}
	}
	
	public void receberEntrada(String opcao, Projeto projeto) {
		
	}
}
