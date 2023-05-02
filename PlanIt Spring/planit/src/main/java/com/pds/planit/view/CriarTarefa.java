//package com.pds.planit.view;
//
//import com.pds.planit.controller.TarefaController;
//import com.pds.planit.entity.Tarefa;
//
//import java.util.Scanner;
//
//public class CriarTarefa implements MenuTarefa{
//    public TarefaController controller = new TarefaController();
//    @Override
//    public void exibirConteudo() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Insira o nome da Tarefa:");
//        String nome = scanner.nextLine();
//
//        System.out.println("Insira a descrição da Tarefa:");
//        String descricao = scanner.nextLine();
//
//        receberEntrada(nome,descricao);
//    }
//
//    @Override
//    public void receberEntrada(String nome, String descricao) {
//        Tarefa tarefa = new Tarefa(nome, descricao);
//        controller.criarTarefa(tarefa);
//    }
//
//    @Override
//    public void receberEntrada(int opcao) {
//
//    }
//
//}
