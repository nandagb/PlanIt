package entity;

public class Projeto {
	private int id;
	private String nome;
	private Usuario[] equipe = new Usuario[1];
	private float andamento;
	private int id_relatorio;

	private static int ultimoId;
	
	public Projeto(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.andamento = 0;
	}

	public Projeto(String nome){
		this.id = getNextId();
		this.nome = nome;
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

	public void setUltimoId(int id){
		this.ultimoId = id;
	}

	public void setIdRelatorio(int id_relatorio) {
		this.id_relatorio = id_relatorio;
	}

	public int getId_relatorio(){
		return this.id_relatorio;
	}
}
