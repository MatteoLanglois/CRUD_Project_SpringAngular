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
 * Classe représentant une réservation dans la base de données.
 * Elle est mappée sur la table "reservation" et utilise une clé composée pour la relation entre {@link User} et {@link Box}.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Entity} : Indique que cette classe est une entité JPA.</li>
 *     <li>{@link Table} : Définit la table associée à cette entité, nommée "reservation".</li>
 *     <li>{@link EmbeddedId} : Utilise une clé composée pour identifier de manière unique chaque instance de réservation.</li>
 *     <li>{@link ManyToOne} : Spécifie la relation plusieurs-à-un avec les entités {@link User} et {@link Box}.</li>
 *     <li>{@link MapsId} : Utilisée pour associer les clés étrangères des entités {@link User} et {@link Box} dans la clé composée {@link ReservationId}.</li>
 * </ul>
 *
 * <p>Généré par Lombok :
 * <ul>
 *     <li>{@link Getter} et {@link Setter} : Fournissent automatiquement les accesseurs et mutateurs pour chaque champ.</li>
 *     <li>{@link ToString} : Génère une méthode toString() pour un affichage facile de l'objet.</li>
 *     <li>{@link Builder} : Permet la construction d'une instance de {@code Reservation} via un pattern de type Builder.</li>
 *     <li>{@link AllArgsConstructor} et {@link NoArgsConstructor} : Fournissent des constructeurs pour cette classe.</li>
 * </ul>
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
   * Clé composée de la réservation, utilisant l'embedded id {@link ReservationId}.
   * Elle identifie de manière unique chaque réservation par l'association des clés étrangères.
   */
  @EmbeddedId
  private ReservationId id;

  /**
   * Utilisateur associé à la réservation.
   * Obligatoire et mappé sur la clé composée par {@link MapsId} et {@link JoinColumn}.
   */
  @ManyToOne(optional = false)
  @MapsId("id_user")
  @JoinColumn(name = "id_user_id", nullable = false)
  private User user;

  /**
   * Boîte associée à la réservation.
   * Obligatoire et mappée sur la clé composée par {@link MapsId} et {@link JoinColumn}.
   */
  @ManyToOne(optional = false)
  @MapsId("id_box")
  @JoinColumn(name = "id_box_id", nullable = false)
  private Box box;

  /**
   * Quantité réservée dans la boîte.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private Integer reservation;
}
