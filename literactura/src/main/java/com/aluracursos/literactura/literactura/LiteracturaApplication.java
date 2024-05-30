package com.aluracursos.literactura.literactura;

import com.aluracursos.literactura.literactura.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteracturaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteracturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal =new Principal();
		principal.muestraElMenu();
	}
}
