package com.pedrosobral.gamestorespring.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GameDTO(
@JsonProperty ("_id") Long id,
@NotBlank @NotNull @Length(min = 5, max = 100)String name,
@NotNull @Length(max = 10) @Pattern(regexp = "PS4|XBOX")String plataform,
@NotNull double price,
@NotBlank @NotNull @Length(min = 5, max = 250)String summary) {

}

