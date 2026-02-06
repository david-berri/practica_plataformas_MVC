package com.example.practica_plataformas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class PracticaPlataformasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaPlataformasApplication.class, args);
	}

}
