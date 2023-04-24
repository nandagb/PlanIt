package com.pds.planit.view;

import com.pds.planit.entity.Projeto;

public interface MenuProjeto {
    public void exibirConteudo();
    public void receberEntrada(String nome);

    public void receberEntrada(int opcao);
}
