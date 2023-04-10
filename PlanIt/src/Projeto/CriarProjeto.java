package Projeto;

import java.util.Scanner;

public class CriarProjeto implements Menu {
	
	public void exibirConteudo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o Nome do Projeto:");
		String opcao = scanner.nextLine();
		System.out.println(opcao);
	}
	
	@Override
	public void receberEntrada(String opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberEntrada(int opcao, Projeto projeto) {
		// TODO Auto-generated method stub
		
	}
}
