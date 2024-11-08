package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {
  @EmbeddedId
  private ReservationId id;

  @ManyToOne
  @MapsId("user")
  @JoinColumn(name = "utilisateur_id")
  private User user;

  @ManyToOne
  @MapsId("box")
  @JoinColumn(name = "boite_id")
  private Box box;


  @NonNull
  private Integer reservation;
}
