package Usuario;
import java.util.*;
public class UsuarioRepo {
	private List<Usuario> listaUsuario;
	
	public UsuarioRepo() {
		listaUsuario = new ArrayList<Usuario>();
	}
	
	public void addUsuario(Usuario usuario) {
		listaUsuario.add(usuario);
	}
	
	public Usuario getUsuarioById(int id) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.getId() == id) {
				return usuario;
			}	
		}
		return null;
	}
	
	public void updateUsuario(Usuario updateUsuario) {
		for (Usuario usuario : listaUsuario) {
            if (usuario.getId() == updateUsuario.getId()) {
                usuario.setNome(updateUsuario.getNome());
                usuario.setEmail(updateUsuario.getEmail());
                break;
            }
        }
	}
	
	public void deleteUsuario(int id) {
		listaUsuario.removeIf(usuario -> usuario.getId() == id);
	}
}
