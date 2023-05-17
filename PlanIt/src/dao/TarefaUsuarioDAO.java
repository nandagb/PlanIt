package dao;

import entity.TarefaUsuario;
import entity.Usuario;


import java.sql.SQLException;
import java.util.ArrayList;

public interface TarefaUsuarioDAO {
    public boolean save(TarefaUsuario atribuir) throws SQLException;
    public ArrayList<Usuario> findAllParticipantes(int tarefa_id) throws SQLException;

    public boolean existe(TarefaUsuario usuario);

    public boolean delete(TarefaUsuario participante_removido);
}
