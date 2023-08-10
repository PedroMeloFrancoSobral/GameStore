package com.pedrosobral.gamestorespring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosobral.gamestorespring.dto.GameDTO;
import com.pedrosobral.gamestorespring.service.GameService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
public class GameController {

 private final GameService gameService;

  @GetMapping
  public List<GameDTO> listAll(){
    return gameService.listAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public GameDTO create(@RequestBody @Valid GameDTO game){
    System.out.println(game.getClass().getName());
       return gameService.create(game);
    //return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(game));
  }

  @GetMapping("/{id}")
  public GameDTO findById( @PathVariable @NotNull @Positive Long id){
    return gameService.findById(id);
  }

  @PutMapping("/{id}")
  public GameDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid GameDTO game){
     return gameService.update(id, game);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void delete( @PathVariable @NotNull @Positive Long id){
    gameService.delete(id);
  }
}

