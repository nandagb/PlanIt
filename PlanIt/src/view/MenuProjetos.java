package view;

import controller.ProjetoController;
import controller.TarefaController;
import entity.Projeto;
import entity.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProjetos  implements Menu {
    Projeto projeto;
    ProjetoController controller;

    public MenuProjetos(){
        this.controller = new ProjetoController();
    }

    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 4){
            System.out.println("PROJETOS: \n [1] Criar Projeto \n [2] Buscar Projeto \n " +
                    "[3] Listar Todos os Projetos \n [4] Voltar");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> exibirCriacaoProjeto();
                case 2 -> exibirBuscaProjeto();
                case 3 -> exibirTodosProjetos();
            }
        }
    }

    private void exibirTodosProjetos() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Projeto> projetos = controller.acharTodosProjetos();
        System.out.println("Escolha um projeto: \n");
        projetos.forEach((Projeto projeto) -> System.out.println("[" + projetos.indexOf(projeto) +"] "
                + projeto.getNome()));
        System.out.println("[" + projetos.size() + "] Voltar");
        int opcao = scanner.nextInt();
        if(opcao == projetos.size());
        else gerenciarProjeto(projetos.get(opcao));
    }

    private void exibirCriacaoProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        controller.criaProjeto(Projeto.getNextId(), nome);
        System.out.println("Projeto \"" + nome + "\" Criado com Sucesso!");
    }

    private void exibirBuscaProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        Projeto projeto = controller.pesquisarProjetoNome(nome);
        gerenciarProjeto(projeto);
    }

    private void gerenciarProjeto(Projeto projeto){
        if(projeto.getId() != -1){
            Scanner scanner = new Scanner(System.in);
            this.projeto = projeto;
            System.out.println(projeto.getNome().toUpperCase() + ":\n ");
            System.out.println(" [1] Editar Nome do Projeto \n [2] Tarefas \n [3] Deletar Projeto \n [4] Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> editarProjeto();
                case 2 -> MenuTarefas.exibirConteudo(this.projeto);
                case 3 -> confirmarExclusao();
                case 4 -> exibirConteudo();
            }
        }
        else System.out.println("Projeto não encontrado.");
    }

    private void confirmarExclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem Certeza Que Deseja Apagar o Projeto \"" + this.projeto.getNome() + "\"?");
        System.out.println(" [1] Sim \n [2] Não");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> controller.excluirProjeto(this.projeto);
        }
    }

    private void editarProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira Um Novo Nome Para o Projeto:");
        String nome = scanner.nextLine();
        this.projeto.setNome(nome);
        controller.editarProjeto(this.projeto);
    }
}
