package com.example.demo.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class BoxCreationDTO {
  private Integer id;
  private String nom;
  private Integer quantite;
  private String description;
  private String point_geo;
}
