package com.pedrosobral.gamestorespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosobral.gamestorespring.model.Game;

public interface GameRepository extends JpaRepository<Game,Long> {

}
