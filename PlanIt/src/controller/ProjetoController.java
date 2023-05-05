package controller;
import java.util.*;

import entity.Projeto;
import dao.ProjetoDAO;
import entity.Usuario;

public class ProjetoController {
	
	private ProjetoDAO projetos;
	private List<Projeto> listaProjetos;
	
	public ProjetoController() {
		projetos = new ProjetoDAO();
		listaProjetos = projetos.obterTodosProjetos();
	}
	
	
	
//	ADICIONA MEMBRO A EQUIPE
	public void addMembro(Projeto projeto, Usuario usuario) {
		if(projeto.getEquipe() != null) {
			Usuario[] newEquipe = Arrays.copyOf(projeto.getEquipe(), projeto.getEquipe().length + 1);
			newEquipe[newEquipe.length - 1] = usuario;
		}
		else {
			Usuario[] newEquipe = new Usuario[1];
			newEquipe[0] = usuario;
		}
	}
	
//	REMOVE MEMBRO DA EQUIPE
	public void removeMembro(Projeto projeto, Usuario usuario) {
		int indice_usuario = -1;
		for(int i = 0; i < projeto.getEquipe().length; i++) {
			if(projeto.getEquipe()[i] == usuario) {
				indice_usuario = i;
			}
		}
		
		Usuario[] newEquipe = new Usuario[projeto.getEquipe().length - 1];
		for(int i = 0, j =0; i < newEquipe.length; i ++) {
			if(i != indice_usuario) {
				newEquipe[j++] = projeto.getEquipe()[i];
			}
		}
	}
	
//	ADICIONAR PROJETO
	public void addProjeto(int id, String nome) {
		Projeto projeto = new Projeto(id, nome);
		projetos.criarProjeto(projeto);
	}
	
//	EXCLUIR PROJETOS
	public void excluirProjeto(Projeto projeto) {
			projetos.deleteProjeto(projeto);
	}
	
//	LISTAR PROJETOS
	public void listarProjetos() {		
		ArrayList<Projeto> listaProjetos = projetos.obterTodosProjetos();
		for(int i = 0; i < listaProjetos.size(); i++){
			System.out.println("Projeto: " + listaProjetos.get(i).getNome() + " - " + listaProjetos.get(i).getId());
		}
	}
	
//	PESQUISAR PROJETO
	public Projeto pesquisarProjeto(int id) {
		Projeto projeto = projetos.obterProjeto(id);
		return projeto;
		
	}
	
	//EDITAR PROJETO
	public boolean editarProjeto(Projeto projeto) {
		return projetos.updateProjeto(projeto);
	}
}
