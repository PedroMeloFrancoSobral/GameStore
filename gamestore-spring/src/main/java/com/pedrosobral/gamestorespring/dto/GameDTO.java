package com.pedrosobral.gamestorespring.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedrosobral.gamestorespring.enums.Plataform;
import com.pedrosobral.gamestorespring.enums.PlataformConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GameDTO(
@JsonProperty ("_id") Long id,
@NotBlank @NotNull @Length(min = 5, max = 100)String nome,
@NotNull @Convert(converter = PlataformConverter.class) @Column(name = "plataform", nullable = false) Plataform plataform,
@NotNull double price) {

}
