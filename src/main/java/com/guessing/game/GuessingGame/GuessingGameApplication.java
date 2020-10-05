package com.guessing.game.GuessingGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import resources.GameController;
import services.GameService;

@SpringBootApplication
@ComponentScan({"resources"})
@ComponentScan({"services"})
@EntityScan("domain")
@EnableJpaRepositories("repositories")
public class GuessingGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessingGameApplication.class, args);
	}

}
