package com.pds.planit.view;

import com.pds.planit.entity.Tarefa;

public interface MenuTarefa {

    public void exibirConteudo();
    public void receberEntrada(String nome, String descricao);

    public void receberEntrada(int opcao);
}
