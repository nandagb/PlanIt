package controller;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entity.Projeto;
import entity.Usuario;
import services.ProjetoServices;
import services.UsuarioServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static UsuarioDAOImpl usuarios = new UsuarioDAOImpl();
	private List<Usuario> listaUsuario = usuarios.getAllUsuarios();


    public static boolean createUsuario(Usuario usuario) {
    	if( usuarios.emailEmUso(usuario) ) {
			System.out.println("Este email já foi cadastrado!");
			return false;
		}
		else if (usuarios.save(usuario) == false) {
			System.out.println("Este usuário já existe!");
			return false;
		}
		else {
			System.out.println("Usuário \"" + usuario.getEmail() +  "\" criado com sucesso!");
			return true;
		}
    }

    public Usuario getUsuarioById(int id) {
    	return usuarios.getUsuarioById(id);
    }
    
    public Usuario getUserByEmail(String email) throws SQLException {
    	return usuarios.getUsuarioByEmail(email);
    }

    public static boolean updateUsuario(Usuario updatedUsuario) {
    	return usuarios.updateUsuario(updatedUsuario);
    }

    public static boolean deleteUsuario(Usuario usuario) {
    	if(usuarios.deleteUsuario(usuario)) {
			System.out.println(" Usuário deletado com sucesso!");
			return true;
		}
		else {
			System.out.println("Não foi possível deletar o usuário!");
			return false;
		}
    }
    
    public void show() {
    	for( Usuario usuario : listaUsuario) {
			usuario.printUsuario();
		}
    }

	public  static ArrayList<Usuario> acharTodosUsuarios(){
		ArrayList<Usuario> usuarios = UsuarioServices.validaBuscaTodosUsuarios();
		return usuarios;
	}

	public static Usuario pesquisarUsuarioEmail(String email) {
		Usuario usuario = UsuarioServices.validaUsuarioPesquisaEmail(email);
		return usuario;
	}
    
    
}
