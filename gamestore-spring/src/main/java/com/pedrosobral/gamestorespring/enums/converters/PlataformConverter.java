package com.pedrosobral.gamestorespring.enums.converters;

import java.util.stream.Stream;

import com.pedrosobral.gamestorespring.enums.Plataform;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlataformConverter implements AttributeConverter<Plataform,String>{

  @Override
   public String convertToDatabaseColumn(Plataform plataform) {
    if(plataform== null){
     return null;
    }
    return plataform.getValue();
  }

  @Override
  public Plataform convertToEntityAttribute(String value) {
    if(value== null){
      return null;
    }
    return Stream.of(Plataform.values())
      .filter(c -> c.getValue().equals(value))
      .findFirst()
      .orElseThrow(IllegalArgumentException::new);
}

}
