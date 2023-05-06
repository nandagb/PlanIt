package view;

import entity.Projeto;

public class CriarTarefa implements Menu{

    @Override
    public void exibirConteudo() {
        System.out.println("Informe o Nome da Tarefa:");
    }

    @Override
    public void receberEntrada(int opcao, Projeto projeto) {

    }

    @Override
    public void receberEntrada(String opcao, Projeto projeto) {

    }
}
