package view;

import controller.ProjetoController;
import entity.Projeto;

import java.util.Scanner;

public class MenuProjetos  implements Menu {
    Projeto projeto;

    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PROJETOS: \n\n [1] Criar Projeto \n [2] Buscar Projeto \n [3] Voltar");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> exibirCriacaoProjeto();
            case 2 -> exibirBuscaProjeto();
        }
    }

    private void exibirCriacaoProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        ProjetoController.criaProjeto(Projeto.getNextId(), nome);
        System.out.println("Projeto \"" + nome + "\" Criado com Sucesso!");
    }

    private void exibirBuscaProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        ProjetoController.criaProjeto(Projeto.getNextId(), nome);
        System.out.println("Projeto \"" + nome + "\" Criado com Sucesso!");
    }
}
