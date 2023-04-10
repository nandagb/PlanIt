package Projeto;

import java.util.Scanner;

public class ExcluirProjeto implements Menu {

	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o ID do Projeto:");
		int opcao = scanner.nextInt();
		System.out.println(opcao);
	}
	
	public void receberEntrada(int opcao, Projeto projeto) {
		
	}
	
	public void receberEntrada(String opcao, Projeto projeto) {
		
	}
}
