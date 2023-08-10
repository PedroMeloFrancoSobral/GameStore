package com.pedrosobral.gamestorespring.model;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("_id")
  private Long id;

  @NotBlank
  @NotNull
  @Length(min = 5, max = 100)
  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @NotNull
  @Length(max = 10)
  @Pattern(regexp = "PS4|XBOX")
  @Column(name = "plataform", length = 10, nullable = false)
  private String plataform;

  @NotNull
  @Column(name = "price", length = 200, nullable = false)
  private double price;


}
