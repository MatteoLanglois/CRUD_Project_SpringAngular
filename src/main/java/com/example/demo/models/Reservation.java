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

/**
 * Représente une réservation d'un utilisateur pour une boîte spécifiée.
 *
 * La classe `Reservation` contient un identifiant composite, la relation avec l'utilisateur (`User`) et la boîte (`Box`) correspondante,
 * ainsi que le statut ou le nombre de réservations associées.
 *
 * Cette entité est mappée à la table "reservation" dans la base de données.
 *
 * @see ReservationId
 * @see User
 * @see Box
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "reservation")
public class Reservation {

  /**
   * Identifiant composite de la réservation. Utilisé pour lier cette entité avec l'utilisateur et la boîte.
   *
   * Ce champ est défini avec l'annotation `@EmbeddedId`, qui permet de l'utiliser comme clé primaire composée.
   */
  @EmbeddedId
  private ReservationId id;

  /**
   * Relation Many-to-One entre la réservation et l'utilisateur.
   *
   * Utilise l'annotation `@ManyToOne` pour définir une relation avec l'entité `User`.
   * La clé étrangère est mappée sur la colonne `utilisateur_id`.
   */
  @ManyToOne
  @MapsId("user")
  @JoinColumn(name = "utilisateur_id")
  private User user;

  /**
   * Relation Many-to-One entre la réservation et la boîte.
   *
   * Utilise l'annotation `@ManyToOne` pour définir une relation avec l'entité `Box`.
   * La clé étrangère est mappée sur la colonne `boite_id`.
   */
  @ManyToOne
  @MapsId("box")
  @JoinColumn(name = "boite_id")
  private Box box;

  /**
   * Le nombre de réservations effectuées. Ce champ est requis et ne peut pas être nul.
   *
   * Cette valeur représente une information supplémentaire sur la réservation.
   */
  @NonNull
  private Integer reservation;
}
