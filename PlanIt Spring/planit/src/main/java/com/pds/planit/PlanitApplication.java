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
			criarUsuario(usuarioDAO);
		};
	}

	private void criarUsuario(UsuarioDAO usuarioDAO) {
		System.out.println("Criando usuario novo...");
		Usuario tempUsuario = new Usuario("nome", "email", "senha");

		System.out.println("Salvando usuario novo...");
		usuarioDAO.save(tempUsuario);

		tempUsuario.printUsuario();

	}
}
