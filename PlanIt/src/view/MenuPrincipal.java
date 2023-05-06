package view;

import java.util.Scanner;

import entity.Projeto;
import entity.Usuario;

public class MenuPrincipal implements Menu {
	
	public MenuPrincipal() {
		
	}
	
	@Override
	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		Menu menu;
		System.out.println("Escolha uma opção \n\n [1] Criar Novo Projeto \n [2] Editar Projeto \n [3] Excluir Projeto \n [4] Listar Projetos");
		int opcao = scanner.nextInt();
		Usuario[] equipe;
		Projeto projeto = new Projeto(1, "Projeto");
		receberEntrada(opcao, projeto);
	}
	
	@Override
	public void receberEntrada(String opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberEntrada(int opcao, Projeto projeto) {
		Scanner scanner = new Scanner(System.in);
		Menu menu;
		if(opcao == 1) {
			menu = new CriarProjeto();
			menu.exibirConteudo();
		}
		else if(opcao == 2) {
			menu = new EditarProjeto();
			menu.exibirConteudo();
		}
		else if(opcao == 3) {
			menu = new ExcluirProjeto();
			menu.exibirConteudo();
		}
		else if(opcao == 4) {			
			menu = new ExibirProjetos();
			menu.exibirConteudo();
		}
		
	}

	public static void main(String args[]) {
		Menu menu = new MenuPrincipal();
		menu.exibirConteudo();
		
	}
}
