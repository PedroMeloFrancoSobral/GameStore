package com.pedrosobral.gamestorespring.enums;

public enum Plataform {
  PS4("Playstation 4"),
  XBOX("XBOX");

  private String value;

  private Plataform(String value){
    this.value=value;
  }

  public String getValue(){
    return value;
  }

  @Override
  public String toString(){
    return value;
  }
}
