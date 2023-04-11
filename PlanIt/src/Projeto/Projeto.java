package Projeto;
import Usuario.Usuario;
import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.List;

import Usuario.Usuario;

public class Projeto {
	private int id;
	private String nome;
	private Usuario[] equipe = new Usuario[1];
	private float andamento;
	
	public Projeto(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.andamento = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Usuario[] getEquipe() {
		return this.equipe;
	}
	
	public void setEquipe(Usuario[] equipe) {
		this.equipe = equipe;
	}
	
	public float getAndamento() {
		return andamento;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAndamento(float andamento) {
		this.andamento = andamento;
	}
}
