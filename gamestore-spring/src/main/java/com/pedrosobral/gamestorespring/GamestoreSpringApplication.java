package com.pedrosobral.gamestorespring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedrosobral.gamestorespring.enums.Plataform;
import com.pedrosobral.gamestorespring.model.Game;
import com.pedrosobral.gamestorespring.repository.GameRepository;

@SpringBootApplication
public class GamestoreSpringApplication {
  GameRepository gameRepository;
	public static void main(String[] args) {
		SpringApplication.run(GamestoreSpringApplication.class, args);

  }


  @Bean
  CommandLineRunner initDataBase(GameRepository gameRepository) {
    return args -> {
      gameRepository.deleteAll();
      Game game1 = new Game();
      game1.setName("teste");
      game1.setPlataform(Plataform.PS4);
      game1.setSummary("Testando o resumo");
      game1.setPrice(100.00);
      gameRepository.save(game1);
    };
  }

}
