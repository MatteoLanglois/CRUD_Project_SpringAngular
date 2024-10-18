package com.example.demo.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
import lombok.ToString;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {
  @EmbeddedId
  private ReservationId id;

  @ManyToOne(optional = false)
  @MapsId("id_user")
  @JoinColumn(name = "id_user_id", nullable = false)
  private User id_user;

  @ManyToOne(optional = false)
  @MapsId("id_box")
  @JoinColumn(name = "id_box_id", nullable = false)
  private Box id_box;

  @NonNull
  private int reservation;
}
