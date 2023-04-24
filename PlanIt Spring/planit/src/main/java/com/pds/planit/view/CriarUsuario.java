package com.pds.planit.view;

import com.pds.planit.controller.UsuarioController;
import com.pds.planit.entity.Usuario;

import java.util.Scanner;

public class CriarUsuario implements MenuUsuario{

    public UsuarioController controller = new UsuarioController();
    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do Usuario:");
        String nome = scanner.nextLine();

        System.out.println("Insira o email do Usuario:");
        String email = scanner.nextLine();

        System.out.println("Insira o senha do Usuario:");
        String senha = scanner.nextLine();

        receberEntrada(nome, email, senha);
    }

    @Override
    public void receberEntrada(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        controller.criarUsuario(usuario);
    }

}
