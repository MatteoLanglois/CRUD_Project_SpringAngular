package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Représente un identifiant composite pour une réservation, utilisé pour lier un utilisateur et une boîte dans une réservation.
 *
 * Cette classe contient deux champs : l'ID de l'utilisateur (`id_user`) et l'ID de la boîte (`id_box`), qui sont utilisés ensemble
 * comme clé primaire composée dans l'entité `Reservation`.
 *
 * Cette classe est marquée avec l'annotation `@Embeddable`, ce qui signifie qu'elle peut être incluse comme un identifiant composite
 * dans une autre entité.
 *
 * @see Reservation
 */
@Embeddable
@EqualsAndHashCode
public class ReservationId {

  /**
   * L'ID de l'utilisateur associé à la réservation.
   *
   * Ce champ représente l'identifiant unique de l'utilisateur qui effectue la réservation.
   * Il est marqué comme non nul avec `nullable = false` pour garantir que l'ID de l'utilisateur est toujours renseigné.
   */
  @Column(name = "id_user", nullable = false)
  private int id_user;

  /**
   * L'ID de la boîte associée à la réservation.
   *
   * Ce champ représente l'identifiant unique de la boîte réservée.
   * Il est marqué comme non nul avec `nullable = false` pour garantir que l'ID de la boîte est toujours renseigné.
   */
  @Column(name = "id_box", nullable = false)
  private int id_box;
}
