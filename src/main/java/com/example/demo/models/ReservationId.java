package com.example.demo.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class ReservationId {
  @ManyToOne
  @JoinColumn(name = "utilisateur_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "boite_id", nullable = false)
  private Box box;
}