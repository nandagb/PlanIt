package com.pds.planit;

import com.pds.planit.dao.UsuarioDAO;
import com.pds.planit.entity.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlanitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanitApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UsuarioDAO usuarioDAO){
		return runner -> {
			//criarUsuario(usuarioDAO);

			lerUsuario(usuarioDAO);
		};
	}

	private void lerUsuario(UsuarioDAO usuarioDAO) {
		System.out.println("Procurando usuario com id: 1");
		Usuario usuario = usuarioDAO.findById(1);
		usuario.printUsuario();

	}

	private void criarUsuario(UsuarioDAO usuarioDAO) {
		System.out.println("Criando usuario novo...");
		Usuario tempUsuario = new Usuario("novoNome", "novoEmail", "novaSenha");

		System.out.println("Salvando usuario novo...");
		usuarioDAO.save(tempUsuario);

		tempUsuario.printUsuario();

	}
}
