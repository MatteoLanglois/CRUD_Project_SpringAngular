package com.example.demo.models.DTO;

import lombok.Data;

@Data
public class BoxDTO {
  private Integer id;
  private String nom;
  private Integer quantite;
  private String description;
  private String point_geo;
}
