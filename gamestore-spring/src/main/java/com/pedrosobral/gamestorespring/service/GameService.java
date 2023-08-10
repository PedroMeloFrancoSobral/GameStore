package com.pedrosobral.gamestorespring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.pedrosobral.gamestorespring.exceptions.RecordNotFoundException;
import com.pedrosobral.gamestorespring.model.Game;
import com.pedrosobral.gamestorespring.repository.GameRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class GameService {

private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public List<Game> listAll(){
    return gameRepository.findAll();
  }

  public Game create( @Valid Game game){
    return gameRepository.save(game);
  }

  public Game findById( @PathVariable @NotNull @Positive Long id){
    return gameRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id));
  }

  public Game update( @NotNull @Positive Long id, @Valid Game game){
    return gameRepository.findById(id)
      .map(recordFound -> {
        recordFound.setName(game.getName());
        recordFound.setPlataform(game.getPlataform());
        recordFound.setPrice(game.getPrice());
        return gameRepository.save(recordFound);
    }).orElseThrow(()-> new RecordNotFoundException(id));
  }

  public void delete( @PathVariable @NotNull @Positive Long id){
    gameRepository.delete(gameRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id)));
  }
}
