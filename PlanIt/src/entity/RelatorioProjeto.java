package entity;

public class RelatorioProjeto implements Relatorio{
    private int ntarefas;
    private int ntarefas_concluidas;
    private float porcentagem_concluido;
    private float tmedio_tarefa;
    private int tarefas_atrasadas;
    private int ntarefas_sem_usuario;
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

    public int getId(){
        return this.id;
    }

    public void printRelatorio(){
        System.out.println("===================================================");
        System.out.println("\t\t\t\tRelatório");
        System.out.println("Número de tarefas: " + ntarefas);
        System.out.println("Número de tarefas concluídas: " + ntarefas_concluidas);
        System.out.println("Porcentagem de tarefas concluídas: " + porcentagem_concluido);
        System.out.println("Tempo médio de resolução de tarefa: " + tmedio_tarefa);
        System.out.println("Número de tarefas sem participantes: " + ntarefas_sem_usuario);
        System.out.println("===================================================");
        System.out.println();

    }


}
