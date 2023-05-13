package view;

import controller.TarefaController;
import entity.Projeto;
import entity.Tarefa;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MenuTarefas {
    public static void exibirConteudo(Projeto projeto){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" [1] Exibir Tarefas \n [2] Criar Tarefa");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> exibirTarefas(projeto);
            case 2 -> criarTarefas(projeto);
        }
    }
    public static void exibirTarefas(Projeto projeto){
        ArrayList<Tarefa> tarefas = TarefaController.acharTarefasProjeto(projeto.getId());
        if(tarefas.size() == 0){
            System.out.println("Nenhuma Tarefa Encontrada");
            exibirConteudo(projeto);
        }
        else {
            System.out.println("Selecione Uma Tarefa:");
            tarefas.forEach((Tarefa tarefa) -> System.out.println("[" + tarefas.indexOf(tarefa)
                    + "] " + tarefa.getNome()));
        }
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
                "Ex: 31-12-2002");
        long prazo = scanner.nextLong();
        Date prazosql = new Date(prazo);
        tarefa.setPrazo(prazosql);
        TarefaController.criarTarefa(tarefa);
    }
}
