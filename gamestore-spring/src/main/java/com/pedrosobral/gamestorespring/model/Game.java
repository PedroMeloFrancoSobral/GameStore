package com.pedrosobral.gamestorespring.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosobral.gamestorespring.enums.Plataform;
import com.pedrosobral.gamestorespring.enums.PlataformConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
@SQLDelete(sql = "UPDATE Games SET status = 'Inativo' WHERE id= ?")
@Where(clause = "status= 'Ativo'")
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
  @Convert(converter = PlataformConverter.class)
  @Column(name = "plataform", nullable = false)
  private Plataform plataform;

  @NotNull
  @Column(name = "price", length = 200, nullable = false)
  private double price;

  @NotNull
  @Length(max = 10)
  @Pattern(regexp = "Ativo|Inativo")
  @Column(name = "status", length = 10, nullable = false)
  private String status = "Ativo";


}
