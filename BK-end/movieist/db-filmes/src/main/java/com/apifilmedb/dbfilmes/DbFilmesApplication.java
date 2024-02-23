package com.apifilmedb.dbfilmes;

import org.springframework.boot.SpringApplication; //importa a classe 'SpringApplication' para usar o método 'run'
import org.springframework.boot.autoconfigure.SpringBootApplication; //importa as anotações do springboot, para avisar ao compilador sobre o que cada classe faz.
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DbFilmesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DbFilmesApplication.class, args);
	}                                     //chamando o metodo run da classe 'SpringApplication' e passando a classe publica da DB.

}
