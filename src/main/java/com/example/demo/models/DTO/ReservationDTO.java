package com.example.demo.models.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ReservationDTO {
  private Integer id_user;
  private Integer id_box;
  private int reservation;
}
