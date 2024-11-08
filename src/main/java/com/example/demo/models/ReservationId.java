package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ReservationId {
  @Column(name = "id_user", nullable = false)
  private int id_user;

  @Column(name = "id_box", nullable = false)
  private int id_box;
}