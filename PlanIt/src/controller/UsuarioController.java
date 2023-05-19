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
    private UsuarioDAOImpl dao = new UsuarioDAOImpl();

	private UsuarioServices services;
	private List<Usuario> listaUsuario = dao.getAllUsuarios();

	public UsuarioController(){
		this.services = new UsuarioServices();
	}

    public void createUsuario(Usuario usuario) {
    	if( dao.emailEmUso(usuario) ) {
			System.out.println("Este email já foi cadastrado!");
		}
		else if (dao.save(usuario) == false) {
			System.out.println("Este usuário já existe!");
		}
		else {
			System.out.println("Usuário \"" + usuario.getEmail() +  "\" criado com sucesso!");
		}
    }

    public Usuario getUsuarioById(int id) {
    	return dao.getUsuarioById(id);
    }
    
    public Usuario getUserByEmail(String email) throws SQLException {
    	return dao.getUsuarioByEmail(email);
    }

    public void updateUsuario(Usuario updatedUsuario) {
    	dao.updateUsuario(updatedUsuario);
    }

    public void deleteUsuario(Usuario usuario) {
    	if(dao.deleteUsuario(usuario)) {
			System.out.println(" Usuário deletado com sucesso!");
		}
		else {
			System.out.println("Não foi possível deletar o usuário!");
		}
    }
    
    public void show() {
    	for( Usuario usuario : listaUsuario) {
			usuario.printUsuario();
		}
    }

	public ArrayList<Usuario> acharTodosUsuarios(){
		ArrayList<Usuario> usuarios = services.validaBuscaTodosUsuarios();
		return usuarios;
	}

	public Usuario pesquisarUsuarioEmail(String email) {
		Usuario usuario = services.validaUsuarioPesquisaEmail(email);
		return usuario;
	}
    
    
}
