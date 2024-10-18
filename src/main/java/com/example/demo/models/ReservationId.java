package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservationId {
  @Column(name = "id_user", nullable = false)
  private int id_user;

  @Column(name = "id_box", nullable = false)
  private int id_box;
}