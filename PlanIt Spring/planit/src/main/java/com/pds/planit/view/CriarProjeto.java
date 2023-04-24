package com.pds.planit.view;

import com.pds.planit.controller.ProjetoController;
import com.pds.planit.entity.Projeto;

import java.util.Scanner;

public class CriarProjeto implements MenuProjeto {
    public ProjetoController controller = new ProjetoController();
    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o Nome do Projeto:");
        String nome = scanner.nextLine();
        receberEntrada(nome);

    }

    @Override
    public void receberEntrada(String nome) {
        Projeto projeto = new Projeto(nome);
        controller.criarProjeto(projeto);

    }

    @Override
    public void receberEntrada(int opcao) {

    }
}
