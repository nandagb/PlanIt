package com.pds.planit.view;

import com.pds.planit.entity.Tarefa;

public interface MenuTarefa {

    public void exibirConteudo();
    public void receberEntrada(int opcao, Tarefa tarefa);
    public void receberEntrada(String opcao, Tarefa tarefa);
}
