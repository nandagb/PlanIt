package view;

import controller.TarefaController;
import entity.Projeto;
import entity.Tarefa;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MenuTarefas {
    static Projeto projetoTarefas;
    public static void exibirConteudo(Projeto projeto){
        projetoTarefas = projeto;
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 3){
            System.out.println(" [1] Exibir Tarefas \n [2] Criar Tarefa \n [3] Voltar");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> exibirTarefas(projeto);
                case 2 -> criarTarefas(projeto);
            }
        }
    }
    public static void exibirTarefas(Projeto projeto){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = TarefaController.acharTarefasProjeto(projeto.getId());
        if(tarefas.size() == 0){
            System.out.println("Nenhuma Tarefa Encontrada");
            exibirConteudo(projeto);
        }
        else {
            System.out.println("Selecione Uma Tarefa:");
            tarefas.forEach((Tarefa tarefa) -> System.out.println("[" + tarefas.indexOf(tarefa)
                    + "] " + tarefa.getNome() + (tarefa.getStatus().equals("finalizado") ? " - [X]" : " - []")));
            int opcao = scanner.nextInt();
            gerenciarTarefas(tarefas.get(opcao));
        }
    }

    private static void gerenciarTarefas(Tarefa tarefa) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(true){
            System.out.println(tarefa.getNome().toUpperCase() + "\n");
            System.out.println(" [1] Editar Tarefa \n [2] Marcar Como Concluída \n" +
                    " [3] Deletar Tarefa \n [4] Ver Participantes \n [5] Voltar");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> editarTarefa(tarefa);
                case 2 -> TarefaController.toggleConclusaoTarefa(tarefa);
                case 3 -> confirmarExclusaoTarefa(tarefa);
//            case 4 -> verParticipantes(tarefa);
                case 5 -> exibirConteudo(projetoTarefas);
            }
        }
    }

    private static void confirmarExclusaoTarefa(Tarefa tarefa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja Mesmo Excluir a Tarefa \"" + tarefa.getNome() + "\"?");
        System.out.println(" [1] Sim \n [2] Não");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> TarefaController.deletarTarefa(tarefa);
        }
        exibirConteudo(projetoTarefas);
    }

    private static void editarTarefa(Tarefa tarefa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O Que Deseja Editar? \n");
        System.out.println(" [1] Nome \n [2] Descrição \n [3] Prazo \n");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                System.out.println("Insira o Novo Nome Para a Tarefa:");
                scanner.nextLine();
                String nome = scanner.nextLine();
                tarefa.setNome(nome);
                break;
            case 2:
                System.out.println("Insira Uma Nova Descrição Para a Tarefa:");
                scanner.nextLine();
                String descricao = scanner.nextLine();
                tarefa.setDescricao(descricao);
                break;
            case 3:
                System.out.println("Insira um Novo Prazo Para a Tarefa:");
                scanner.nextLine();
                String prazoString = scanner.nextLine();
                int ano = Integer.parseInt(prazoString.split("/")[2]);
                int mes = Integer.parseInt(prazoString.split("/")[1]);
                int dia = Integer.parseInt(prazoString.split("/")[0]);
                LocalDate localDate = LocalDate.of(ano, mes, dia);
                Date prazosql = Date.valueOf(localDate);
                tarefa.setPrazo(prazosql);
                break;
        }
        TarefaController.atualizarTarefa(tarefa);
    }

    private static void criarTarefas(Projeto projeto) {
        Scanner scanner = new Scanner(System.in);
        Tarefa tarefa = new Tarefa();
        tarefa.setProject_id(projeto.getId());
        System.out.println("Escreva o Nome da Tarefa:");
        String nome = scanner.nextLine();
        tarefa.setNome(nome);
        System.out.println("Escreva a Descrição da Tarefa:");
        String descricao = scanner.nextLine();
        tarefa.setDescricao(descricao);
        System.out.println("Escreva o Prazo da Tarefa: \n" +
                "Ex: 31/12/2023");
        String prazoString = scanner.nextLine();
        int ano = Integer.parseInt(prazoString.split("/")[2]);
        int mes = Integer.parseInt(prazoString.split("/")[1]);
        int dia = Integer.parseInt(prazoString.split("/")[0]);
        LocalDate localDate = LocalDate.of(ano, mes, dia);
        Date prazosql = Date.valueOf(localDate);
        tarefa.setPrazo(prazosql);
        boolean criacao = TarefaController.criarTarefa(tarefa);
        if(criacao == false){
            System.out.println("Não Foi Possível Criar a Tarefa.");
        }
        exibirConteudo(projeto);
    }
}
