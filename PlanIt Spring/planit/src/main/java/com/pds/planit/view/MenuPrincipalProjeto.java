package com.pds.planit.view;

import java.util.Scanner;
public class MenuPrincipalProjeto implements MenuProjeto{

    MenuProjeto menu;
    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção \n\n [1] Criar Novo Projeto \n [2] Editar Projeto \n [3] Excluir Projeto \n [4] Listar Projeto");
        int opcao = scanner.nextInt();
        receberEntrada(opcao);
    }

    @Override
    public void receberEntrada(String nome) {

    }

    @Override
    public void receberEntrada(int opcao) {

        if(opcao == 1) {
            menu = new CriarProjeto();
            menu.exibirConteudo();
        }
//        else if(opcao == 2) {
//            menu = new EditarProjeto();
//            menu.exibirConteudo();
//        }
//        else if(opcao == 3) {
//            menu = new ExcluirProjeto();
//            menu.exibirConteudo();
//        }
//        else if(opcao == 4) {
//            menu = new ExibirProjetoo();
//            menu.exibirConteudo();
//        }
    }
}
