package entity;
import java.util.*;
public class Usuario {
	private int id;
	private String nome = "";
	private String email;
	private String senha;

	private static int ultimoId;
	
	public Usuario() {
	}

	public Usuario(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public Usuario(int id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void printUsuario() {
		System.out.println("Nome: " + this.nome + " Email: " + this.email + " Id: " + this.id);
	}

	public static int getNextId(){
		ultimoId ++;
		return ultimoId;
	}

	public static int getUltimoId() {
		return ultimoId;
	}

	public void setUltimoId(int id){
		this.ultimoId = id;
	}
	
	
}
