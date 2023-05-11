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
		System.out.println("O que Deseja Acessar? \n\n [1] Projetos \n [2] Usuarios \n [3] Relatórios");
		int opcao = scanner.nextInt();
		Usuario[] equipe;
		Projeto projeto = new Projeto(1, "Projeto");
		switch (opcao){
			case 1:
				menu = new MenuProjetos();
				menu.exibirConteudo();
		}
	}

	public static void main(String args[]) {
		Menu menu = new MenuPrincipal();
		menu.exibirConteudo();
		
	}
}
