package com.pds.planit.view;

import java.util.Scanner;
public class MenuPrincipalUsuario implements MenuUsuario{
    MenuUsuario menu;
    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção \n\n [1] Criar Novo Usuário \n [2] Editar Usuario \n [3] Excluir Usuário \n [4] Listar Usuário");
        int opcao = scanner.nextInt();
        receberEntrada(opcao);
    }

    @Override
    public void receberEntrada(String nome, String email, String senha) {

    }

    @Override
    public void receberEntrada(int opcao) {
        if(opcao == 1) {
            menu = new CriarUsuario();
            menu.exibirConteudo();
        }
//        else if(opcao == 2) {
//            menu = new EditarUsuario();
//            menu.exibirConteudo();
//        }
//        else if(opcao == 3) {
//            menu = new ExcluirUsuario();
//            menu.exibirConteudo();
//        }
//        else if(opcao == 4) {
//            menu = new ExibirUsuario();
//            menu.exibirConteudo();
//        }
    }
}
