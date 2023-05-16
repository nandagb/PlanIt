package entity;

public class TarefaUsuario {
    public int id_tarefa;
    public int id_usuario;

    public TarefaUsuario(){

    }

    public TarefaUsuario(int id_tarefa, int id_usuario){
        this.id_tarefa = id_tarefa;
        this.id_usuario = id_usuario;
    }

    public int getTarefaId(){
        return this.id_tarefa;
    }

    public int getUsuarioId(){
        return this.id_usuario;
    }
}
