package com.pedrosobral.gamestorespring.dto.mapper;

import org.springframework.stereotype.Component;

import com.pedrosobral.gamestorespring.dto.GameDTO;
import com.pedrosobral.gamestorespring.enums.Plataform;
import com.pedrosobral.gamestorespring.model.Game;

@Component
public class GameMapper {
  public GameDTO toDTO(Game game){
    if(game == null){
      return null;
    }
    return new GameDTO(game.getId(),game.getName(),game.getPlataform().getValue(),game.getPrice());
  }

  public Game toEntity(GameDTO gameDTO){
    if(gameDTO == null){
      return null;
    }
    Game game = new Game();
    if(gameDTO.id()!= null){
      game.setId(gameDTO.id());
    }
    game.setName(gameDTO.name());
    game.setPlataform(convertPlataformValue(gameDTO.plataform()));

    game.setPrice(gameDTO.price());
    return game;
  }

  public Plataform convertPlataformValue(String value){
      if(value == null){
        return null;
      }
      return switch(value){
        case "PS4"-> Plataform.PS4;
        case "XBOX"-> Plataform.XBOX;
        default -> throw new IllegalArgumentException ("Categoria inválida: " + value);
      };

    }
}

