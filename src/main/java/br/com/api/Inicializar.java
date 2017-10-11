package br.com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.api")
public class Inicializar {	
	
	public static void main(String[] args) {
		SpringApplication.run(Inicializar.class, args);
	}
}
