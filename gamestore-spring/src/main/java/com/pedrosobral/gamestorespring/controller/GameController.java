package com.pedrosobral.gamestorespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosobral.gamestorespring.model.Game;
import com.pedrosobral.gamestorespring.repository.GameRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GameController {

 private final GameRepository gameRepository;

  @GetMapping
  public List<Game> listAll(){
    return gameRepository.findAll();
 }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Game create(@RequestBody @Valid Game game){
    return gameRepository.save(game);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Game> findById( @PathVariable @NotNull @Positive Long id){
    return gameRepository.findById(id)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse(ResponseEntity.notFound().build());
  }
  @PutMapping("/{id}")
  public ResponseEntity<Game> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Game game){
    return gameRepository.findById(id)
      .map(recordFound -> {
        recordFound.setName(game.getName());
        recordFound.setPlataform(game.getPlataform());
        recordFound.setPrice(game.getPrice());
        Game updated = gameRepository.save(recordFound);
        return ResponseEntity.ok().body(updated);
      })
    .orElse(ResponseEntity.notFound().build());
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete( @PathVariable @NotNull @Positive Long id){
    return gameRepository.findById(id).map(recordFound-> {
      gameRepository.deleteById(id);
      return ResponseEntity.noContent().<Void>build();
    })
    .orElse(ResponseEntity.notFound().build());
    }
}
