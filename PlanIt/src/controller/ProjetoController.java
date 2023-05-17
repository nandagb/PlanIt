package controller;
import java.util.*;

import entity.Projeto;
import dao.ProjetoDAOImpl;
import entity.Usuario;
import services.ProjetoServices;

public class ProjetoController {
	
	private ProjetoDAOImpl projetos;
	private ProjetoServices services;
	private List<Projeto> listaProjetos;
	
	public ProjetoController() {
		projetos = new ProjetoDAOImpl();
		listaProjetos = projetos.getAllProjetos();
		this.services = new ProjetoServices();
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
	public void criaProjeto(int id, String nome) {
		Projeto projeto = new Projeto(id, nome);
		services.validaProjetoCriacao(projeto);
	}
	
//	EXCLUIR PROJETOS
	public void excluirProjeto(Projeto projeto) {
			ProjetoDAOImpl dao = new ProjetoDAOImpl();
			dao.deleteProjeto(projeto);
	}
	
//	LISTAR PROJETOS
	public void listarProjetos() {		
		ArrayList<Projeto> listaProjetos = projetos.getAllProjetos();
		for(int i = 0; i < listaProjetos.size(); i++){
			System.out.println("Projeto: " + listaProjetos.get(i).getNome() + " - " + listaProjetos.get(i).getId());
		}
	}
	
//	PESQUISAR PROJETO POR ID
	public Projeto pesquisarProjetoId(int id) {
		Projeto projeto = services.validaProjetoPesquisaId(id);
		return projeto;
	}

	//PESQUISAR PROJETO POR NOME
	public Projeto pesquisarProjetoNome(String nome) {
		Projeto projeto = services.validaProjetoPesquisaNome(nome);
		return projeto;
	}
	
	//EDITAR PROJETO
	public boolean editarProjeto(Projeto projeto) {
		services.validaProjetoPesquisaId(projeto.getId());
		if(projeto.getId() != -1){
			ProjetoDAOImpl dao = new ProjetoDAOImpl();
			dao.updateProjeto(projeto);
			return true;
		}
		return false;
	}

	public ArrayList<Projeto> acharTodosProjetos(){
		ArrayList<Projeto> projetos = services.validaBuscaTodosProjetos();
		return projetos;
	}
}
