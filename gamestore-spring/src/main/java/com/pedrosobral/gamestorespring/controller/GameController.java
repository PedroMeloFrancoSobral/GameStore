package com.pedrosobral.gamestorespring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
