package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

/**
 * Classe représentant l'identifiant composé d'une réservation dans la base de données.
 * Cette classe est utilisée comme clé primaire composée pour l'entité {@link Reservation}.
 * Elle combine les identifiants d'un utilisateur et d'une boîte pour créer une clé unique.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Embeddable} : Indique que cette classe peut être intégrée dans une autre entité en tant que clé composée.</li>
 *     <li>{@link Column} : Définit les noms des colonnes correspondantes dans la base de données.</li>
 *     <li>{@link EqualsAndHashCode} : Génère les méthodes equals() et hashCode() pour comparer les instances de cette classe correctement en fonction de leurs valeurs.</li>
 * </ul>
 */
@Embeddable
@EqualsAndHashCode
public class ReservationId {

  /**
   * Identifiant de l'utilisateur dans la réservation.
   * Ce champ fait partie de la clé primaire composée.
   */
  @Column(name = "id_user", nullable = false)
  private int id_user;

  /**
   * Identifiant de la boîte dans la réservation.
   * Ce champ fait également partie de la clé primaire composée.
   */
  @Column(name = "id_box", nullable = false)
  private int id_box;
}
