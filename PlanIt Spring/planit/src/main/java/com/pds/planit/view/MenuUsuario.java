package com.pds.planit.view;


import com.pds.planit.entity.Usuario;

public interface MenuUsuario {
    public void exibirConteudo();
    public void receberEntrada(String nome, String email, String senha);

    public void receberEntrada(int opcao);
}
