package com.pedrosobral.gamestorespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosobral.gamestorespring.model.Game;
import com.pedrosobral.gamestorespring.repository.GameRepository;

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
  public Game create(@RequestBody Game game){
    return gameRepository.save(game);
  }
}
