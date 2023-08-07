package com.pedrosobral.gamestorespring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("_id")
  private Long id;

  @Column(name = "name", length = 200, nullable = false)
  private String name;

  @Column(name = "plataform", length = 200, nullable = false)
  private String plataform;

  @Column(name = "price", length = 200, nullable = false)
  private double price;


}
