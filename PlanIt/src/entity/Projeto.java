package entity;

public class Projeto {
	private int id;
	private String nome;
	private Usuario[] equipe = new Usuario[1];
	private float andamento;

	private static int ultimoId = 0;
	
	public Projeto(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.andamento = 0;
	}

<<<<<<< HEAD
	
=======
	public Projeto(String nome){
		this.id = getNextId();
		this.nome = nome;
	}

>>>>>>> 57729864a74d369863219ac4e2cf5a7782f55533
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
	
	public void setId(int id) {
		this.id = id;
	}

	public static int getNextId(){
		ultimoId ++;
		return ultimoId;
	}

	public static int getUltimoId() {
		return ultimoId;
	}
}
