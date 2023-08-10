package com.pedrosobral.gamestorespring.dto.mapper;

import org.springframework.stereotype.Component;

import com.pedrosobral.gamestorespring.dto.GameDTO;
import com.pedrosobral.gamestorespring.model.Game;

@Component
public class GameMapper {
  public GameDTO toDTO(Game game){
    if(game == null){
      return null;
    }
    return new GameDTO(game.getId(),game.getName(),game.getPlataform(),game.getPrice());
  }

  public Game toEntity(GameDTO gameDTO){
    if(gameDTO == null){
     return null;
    }
    Game game = new Game();
    if(gameDTO.id()!= null){
     game.setId(gameDTO.id());
    }
    game.setName(gameDTO.nome());
    game.setPlataform(gameDTO.plataform());
    game.setPrice(gameDTO.price());
    game.setStatus("Ativo");
    return game;
  }
}
