package Usuario;

public class UsuarioController {
    private UsuarioRepo usuarioRepo;

    public UsuarioController() {
    	usuarioRepo = new UsuarioRepo();
    }

    public void createUser(Usuario usuario) {
    	usuarioRepo.addUsuario(usuario);
    }

    public Usuario getUserById(int id) {
        return usuarioRepo.getUsuarioById(id);
    }
    
    public Usuario getUserByEmail(String email) {
        return usuarioRepo.getUsuarioByEmail(email);
    }

    public void updateUser(Usuario updatedUser) {
    	usuarioRepo.updateUsuario(updatedUser);
    }

    public void deleteUser(Usuario usuario) {
    	usuarioRepo.deleteUsuario(usuario);
    }
    
    public void show() {
    	usuarioRepo.showUsuarios();
    }
    
    
}
