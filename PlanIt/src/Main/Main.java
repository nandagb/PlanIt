package Main;


import java.util.*;

import Usuario.*;

public class Main {
	public static void main(String args[]) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Crie um usuário");
		Usuario usuario = new Usuario();
		
		System.out.println("Insira o nome: ");
		String nome = scanner.nextLine();
		usuario.setNome(nome);
		
		System.out.println("Insira o email: ");
		String email = scanner.nextLine();
		usuario.setEmail(email);
		
		System.out.println("Insira sua senha: ");
		String senha = scanner.nextLine();
		usuario.setSenha(senha);
		
		System.out.println("Insira seu id: ");
		int id = scanner.nextInt();
		usuario.setId(id);
		
		
		//adiciona o usuario ao banco
		UsuarioController controlador = new UsuarioController();
		controlador.createUser(usuario);
		
		//mostra os usuarios
		System.out.println("Lista de usuários: ");
		controlador.show();
		
		//fecha scanner
		scanner.close();
		
		
		
	}
}
