package view;

import controller.UsuarioController;
import entity.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
public class MenuUsuarios implements Menu {
    Usuario usuario;
    UsuarioController controller;

    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 4){
            System.out.println("USUÁRIOS: \n [1] Criar Usuário \n [2] Buscar Usuário \n " +
                    "[3] Listar Todos os Usuários \n [4] Voltar");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> exibirCriacaoUsuario();
                case 2 -> exibirBuscaUsuario();
                case 3 -> exibirTodosUsuarios();
            }
        }
    }

    private void exibirTodosUsuarios() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = UsuarioController.acharTodosUsuarios();
        System.out.println("Escolha um usuario: \n");
        usuarios.forEach((Usuario usuario) -> System.out.println("[" + usuarios.indexOf(usuario) +"] "
                + usuario.getNome()));
        System.out.println("[" + usuarios.size() + "] Voltar");
        int opcao = scanner.nextInt();
        if(opcao == usuarios.size());
        else gerenciarUsuario(usuarios.get(opcao));
    }

    private void exibirCriacaoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Usuario: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o Email Do Usuario: ");
        String email = scanner.nextLine();
        System.out.println("Informe a Senha Do Usuario: ");
        String senha = scanner.nextLine();
        Usuario usuarioTemp = new Usuario(Usuario.getNextId(), nome, email, senha);
        UsuarioController.createUsuario(usuarioTemp);
    }

    private void exibirBuscaUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Email Do Usuario: ");
        String email = scanner.nextLine();
        Usuario usuario = UsuarioController.pesquisarUsuarioEmail(email);
        if(usuario == null){
            System.out.println("Usuário não encontrado!");
            return;
        }
        usuario.printUsuario();
        gerenciarUsuario(usuario);
    }

    private void gerenciarUsuario(Usuario usuario){
        if(usuario.getId() != -1){
            Scanner scanner = new Scanner(System.in);
            this.usuario = usuario;
            this.usuario.printUsuario();
            System.out.println(" [1] Editar Usuario \n [2] Deletar Usuario \n [3] Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> editarUsuario();
                case 2 -> confirmarExclusao();
                case 3 -> exibirConteudo();
            }
        }
        else System.out.println("Usuario não encontrado.");
    }

    private void confirmarExclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem Certeza Que Deseja Deletar o Usuario \"" + this.usuario.getNome() + "\"?");
        System.out.println(" [1] Sim \n [2] Não");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> UsuarioController.deleteUsuario(this.usuario);
        }
    }

    private void editarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja editar no usuário?\n");
        while(true){
            System.out.println(" [1] Nome \n [2] Email \n [3] Senha \n [4] Sair");
            int opcao = scanner.nextInt();
            String tab = scanner.nextLine();
            if(opcao==1){
                System.out.println("Digite o novo nome do usuário: ");
                String nome = scanner.nextLine();
                this.usuario.setNome(nome);
            } else if (opcao==2) {
                System.out.println("Digite o novo email do usuário: ");
                String email = scanner.nextLine();
                this.usuario.setEmail(email);
            } else if (opcao==3) {
                System.out.println("Insira a senha atual do usuário: ");
                String senhaAtual = scanner.nextLine();
                if(senhaAtual.equals(this.usuario.getSenha())){
                    System.out.println("Insira a nova senha");
                    String novaSenha = scanner.nextLine();
                    this.usuario.setSenha(novaSenha);
                }
                else{
                    System.out.println("Senha incorreta!");
                }
            }
            else{
                break;
            }
        }

        UsuarioController.updateUsuario(this.usuario);
    }
}
