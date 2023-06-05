package tests;

import controller.UsuarioController;
import entity.Usuario;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UsuarioControllerTest {
    @Test
    public void createUsuarioTest(){
        Usuario user = new Usuario(1, "teste", "teste@gmail.com", "12345");
        boolean criacaoTrue = UsuarioController.createUsuario(user);
        boolean criacaoFalse = UsuarioController.createUsuario(user);
        assertEquals(criacaoTrue, true);
        assertEquals(criacaoFalse, false);
    }

    @Test
    public void getUsuarioByIdTest(){
        Usuario user = new Usuario(1, "teste", "teste@gmail.com", "12345");
        UsuarioController controller = new UsuarioController();
        Usuario userTrue = controller.getUsuarioById(1);
        Usuario userFalse = controller.getUsuarioById(3);
        assertEquals(1, userTrue.getId());
        assertEquals(null, userFalse);
    }

    @Test
    public void getUserByEmailTest() throws SQLException {
        UsuarioController controller = new UsuarioController();
        Usuario userTrue = controller.getUserByEmail("teste@gmai.com");
        Usuario userFalse = controller.getUserByEmail("teste123@gmail.com");
        assertEquals(1, userTrue.getId());
        assertEquals(null, userFalse);
    }

    @Test
    public void updateUsuarioTest() {
        Usuario user = new Usuario(1, "teste", "testeAtualizado@gmail.com", "12345");
        UsuarioController controller = new UsuarioController();
        boolean userTrue = controller.updateUsuario(user);
        user.setEmail("a");
        boolean userFalse = controller.updateUsuario(user);
        assertTrue(userTrue);
        assertFalse(userFalse);
    }

    @Test
    public void deleteUsuarioTest() {
        Usuario user = new Usuario(1, "teste", "testeAtualizado@gmail.com", "12345");
        UsuarioController controller = new UsuarioController();
        boolean userTrue = controller.deleteUsuario(user);
        boolean userFalse = controller.deleteUsuario(user);
        assertTrue(userTrue);
        assertFalse(userFalse);
    }

    @Test
    public void acharTodosUsuariosTest() {
        Usuario user = new Usuario(1, "teste", "testeAtualizado@gmail.com", "12345");
        UsuarioController controller = new UsuarioController();
        ArrayList<Usuario> users = UsuarioController.acharTodosUsuarios();
        assertTrue(users.size() > 0);
    }

    @Test
    public void pesquisarUsuarioEmailTest() {
        Usuario user = new Usuario(1, "teste", "testeAtualizado@gmail.com", "12345");
        UsuarioController controller = new UsuarioController();
        Usuario userTrue = UsuarioController.pesquisarUsuarioEmail("teste@gmail.com");
        assertEquals(1, userTrue.getId());
    }
}
