package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class ReservationId {
  @Column(name = "id_user", nullable = false)
  private int id_user;

  @Column(name = "id_box", nullable = false)
  private int id_box;
}