package services;


import dao.UsuarioDAOImpl;
import entity.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioServices {
    public static boolean validaUsuarioCriacao(Usuario usuario){
        if(validaEmail(usuario.getNome()) == true){
            UsuarioDAOImpl dao = new UsuarioDAOImpl();
            dao.save(usuario);
            return true;
        }
        return false;
    }

    public static Usuario validaUsuarioPesquisaEmail(String email){
        if(validaEmail(email) == true){
            try{
                UsuarioDAOImpl dao = new UsuarioDAOImpl();
                Usuario usuario = dao.getUsuarioByEmail(email);
                return usuario;
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return new Usuario(-1,"");
    }

    public static Usuario validaUsuarioPesquisaId(int id){
        if(validaId(id) == true){
            UsuarioDAOImpl dao = new UsuarioDAOImpl();
            Usuario projeto = dao.getUsuarioById(id);
            return projeto;
        }
        return new Usuario(-1,"");
    }

    public static boolean validaUsuarioSenha(String senha, Usuario usuario){
        return senha.equals(usuario.getSenha());
    }

    public static boolean validaDelecaoProjeto(Usuario usuario){
        UsuarioDAOImpl dao = new UsuarioDAOImpl();
        if(dao.deleteUsuario(usuario) == true){
            return true;
        }
        return false;
    }

    public static ArrayList<Usuario> validaBuscaTodosUsuarios(){
        UsuarioDAOImpl dao = new UsuarioDAOImpl();
        ArrayList<Usuario> projetos = dao.getAllUsuarios();
        return projetos;
    }

    private static boolean validaEmail(String nome){
        if(nome.trim().length() > 0){
            if(nome.contains("@")){
                return true;
            }
            return false;

        }
        return false;
    }

    private static boolean validaId(int id){
        if(id > 0){
            return true;
        }
        return false;
    }
}
