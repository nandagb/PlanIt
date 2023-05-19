package view;

import controller.TarefaController;
import controller.UsuarioController;
import entity.Tarefa;
import entity.Usuario;

import java.util.ArrayList;
import java.util.Scanner;
public class MenuUsuarios implements Menu {
    Usuario usuario;
    UsuarioController controller;

    public MenuUsuarios(){
        controller = new UsuarioController();
    }

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
        ArrayList<Usuario> usuarios = controller.acharTodosUsuarios();
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
        controller.createUsuario(usuarioTemp);
    }

    private void exibirBuscaUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Email Do Usuario: ");
        String email = scanner.nextLine();
        Usuario usuario = controller.pesquisarUsuarioEmail(email);
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
            System.out.println(" [1] Editar Usuario \n [2] Ver tarefas atribuídas \n [3] Deletar Usuario \n [4] Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> editarUsuario();
                case 2 -> tarefasAtribuidas(usuario);
                case 3 -> confirmarExclusao();
                case 4 -> exibirConteudo();
            }
        }
        else System.out.println("Não foram encontrados usuários.");
    }

    private ArrayList<Tarefa> tarefasAtribuidas(Usuario usuario){
        Scanner scanner = new Scanner(System.in);
        TarefaController controller = new TarefaController();
        ArrayList<Tarefa> tarefas = controller.acharTarefasAtribuidas(usuario.getId());
        if(tarefas.size() == 0){
            System.out.println("Nenhuma Tarefa foi atribuída a esse participante.");
        }
        else {
            System.out.println("Tarefas:");
            tarefas.forEach((Tarefa tarefa_atribuida) -> System.out.println("[" + tarefas.indexOf(tarefa_atribuida)
                    + "] " + tarefa_atribuida.getNome()));
            System.out.println();
        }
        return tarefas;
    }

    private void confirmarExclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem Certeza Que Deseja Deletar o Usuario \"" + this.usuario.getNome() + "\"?");
        System.out.println(" [1] Sim \n [2] Não");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> controller.deleteUsuario(this.usuario);
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

        controller.updateUsuario(this.usuario);
    }
}
