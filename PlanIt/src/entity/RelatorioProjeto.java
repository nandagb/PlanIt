package entity;

public class RelatorioProjeto implements Relatorio{
    private int ntarefas = 0;
    private int ntarefas_concluidas = 0;
    private float porcentagem_concluido = 0;
    private float tmedio_tarefa = 0;
    private int tarefas_atrasadas = 0;
    private int ntarefas_sem_usuario = 0;
    private int id_projeto;
    private int id;
    private static int ultimoId;

    public RelatorioProjeto(){

    }

    public RelatorioProjeto(int id_projeto){
        this.id_projeto = id_projeto;
    }

    public RelatorioProjeto(int id, int num){
        this.id = id;
    }



    public void setNTarefas(int num){
        this.ntarefas = num;
    }

    public void setNTarefasConcluidas(int num){
        this.ntarefas_concluidas = num;
    }

    public void setPorcentagemConcluido(float num){
        this.porcentagem_concluido = num;
    }

    public void setTmedioTarefa(float num){
        this.tmedio_tarefa = num;
    }

    public void setTarefasAtrasadas(int num){
        this.tarefas_atrasadas = num;
    }
    public void setId(int num){
        this.id = num;
    }
    public void setNTarefasSemUsuario(int num){
        this.ntarefas_sem_usuario = num;
    }

    public int getIdProjeto() {
        return id_projeto;
    }

    public int getNTarefasSemUsuario(){
        return this.ntarefas_sem_usuario;
    }

    public int getNTarefas(){
        return this.ntarefas;
    }

    public int getNTarefasConcluidas(){
        return this.ntarefas_concluidas;
    }

    public float getPorcentagemConcluido(){
        return this.porcentagem_concluido;
    }

    public float getTmedioTarefa(){
        return this.tmedio_tarefa;
    }

    public int getTarefasAtrasadas(){
        return this.tarefas_atrasadas;
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
    public void setProjetoI(int id){
        this.id_projeto = id;
    }

    public int getId(){
        return this.id;
    }

    public void printRelatorio(){
        System.out.println("===================================================");
        System.out.println("\t\t\t\tRelatório");
        System.out.println("Número de tarefas: " + this.ntarefas);
        System.out.println("Número de tarefas concluídas: " + this.ntarefas_concluidas);
        System.out.println("Porcentagem de tarefas concluídas: " + this.porcentagem_concluido);
        System.out.println("Tempo médio de resolução de tarefa: " + this.tmedio_tarefa);
        System.out.println("Número de tarefas atrasadas: " + this.tarefas_atrasadas);
        System.out.println("Número de tarefas sem participantes: " + this.ntarefas_sem_usuario);
        System.out.println("===================================================");
        System.out.println();

    }

    public void adicionarTarefa(){
        this.ntarefas++;
    }


}
