package com.guessing.game.GuessingGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import resources.GameController;

@SpringBootApplication
@ComponentScan(basePackageClasses = GameController.class)
public class GuessingGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessingGameApplication.class, args);
	}

}
