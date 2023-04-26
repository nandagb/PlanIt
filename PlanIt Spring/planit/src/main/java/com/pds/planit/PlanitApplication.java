package com.pds.planit;

import com.pds.planit.dao.UsuarioDAO;
import com.pds.planit.entity.Usuario;
import com.pds.planit.view.MenuTarefa;
import com.pds.planit.view.MenuUsuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PlanitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanitApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UsuarioDAO usuarioDAO){
		return runner -> {
			//criarUsuario( usuarioDAO );

			//lerUsuario( usuarioDAO );

			//atualizarUsuario( usuarioDAO );

			//deleterUsuario( usuarioDAO);
		};
	}

	private void deleterUsuario(UsuarioDAO usuarioDAO) {

		System.out.println("imprimindo todos os usuários: ");
		List<Usuario> usuarios = usuarioDAO.findAll();
		for(Usuario usuario : usuarios){
			usuario.printUsuario();
		}

		System.out.println("Deletando usuario com id = 92");

		usuarioDAO.delete(92);

		System.out.println("imprimindo todos os usuários: ");
		List<Usuario> usuarios2 = usuarioDAO.findAll();
		for(Usuario usuario : usuarios2){
			usuario.printUsuario();
		}

	}

	private void atualizarUsuario(UsuarioDAO usuarioDAO) {

		System.out.println("procurando um usuario com id = 92");
		Usuario usuario = usuarioDAO.findById(92);

		System.out.println("Atualizando o nome para Scooby");
		usuario.setNome("Scooby");

		usuarioDAO.update(usuario);

		System.out.println("Usuario atualizado");
		usuario.printUsuario();
	}

	private void lerUsuario(UsuarioDAO usuarioDAO) {
		System.out.println("Procurando usuario com id: 1");
		Usuario usuario1 = usuarioDAO.findById(1);
		usuario1.printUsuario();

		System.out.println("imprimindo todos os usuários: ");
		List<Usuario> usuarios = usuarioDAO.findAll();
		for(Usuario usuario : usuarios){
			usuario.printUsuario();
		}

		System.out.println("Procurando usuario com email: fernanda.goncalves@buzzmonitor.com.br");
		List<Usuario> usuarios2 = usuarioDAO.findByEmail("fernanda.goncalves@buzzmonitor.com.br");
		for(Usuario usuario : usuarios2){
			usuario.printUsuario();
		}


	}

	private void criarUsuario(UsuarioDAO usuarioDAO) {
		System.out.println("Criando usuario novo...");
		Usuario tempUsuario = new Usuario("novoNome", "novoEmail", "novaSenha");

		System.out.println("Salvando usuario novo...");
		usuarioDAO.save(tempUsuario);

		tempUsuario.printUsuario();

	}
}
