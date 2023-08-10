package com.pedrosobral.gamestorespring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.pedrosobral.gamestorespring.dto.GameDTO;
import com.pedrosobral.gamestorespring.dto.mapper.GameMapper;
import com.pedrosobral.gamestorespring.exceptions.RecordNotFoundException;
import com.pedrosobral.gamestorespring.repository.GameRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class GameService {

  private final GameRepository gameRepository;
  private final GameMapper gameMapper;

  public GameService(GameRepository gameRepository,GameMapper gameMapper) {
    this.gameRepository = gameRepository;
    this.gameMapper=gameMapper;
  }

  public List<GameDTO> listAll(){
    return gameRepository.findAll()
      .stream()
      .map(gameMapper::toDTO)
      .collect(Collectors.toList());
  }

  public GameDTO create( @NotNull @Valid GameDTO game){
    return gameMapper.toDTO(gameRepository.save(gameMapper.toEntity(game)));
  }
  public GameDTO findById( @NotNull @Positive Long id){
    return gameRepository.findById(id).map(gameMapper::toDTO).orElseThrow(()-> new RecordNotFoundException(id));
  }

  public GameDTO update( @NotNull @Positive Long id, @Valid GameDTO game){
    return gameRepository.findById(id)
      .map(recordFound -> {
        recordFound.setName(game.name());
        recordFound.setPlataform(gameMapper.convertPlataformValue(game.plataform()));
        recordFound.setPrice(game.price());
        return gameRepository.save(recordFound);
    }).map(gameMapper::toDTO).orElseThrow(()-> new RecordNotFoundException(id));
}

  public void delete( @NotNull @Positive Long id){
      gameRepository.delete(gameRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id)));
  }
}
