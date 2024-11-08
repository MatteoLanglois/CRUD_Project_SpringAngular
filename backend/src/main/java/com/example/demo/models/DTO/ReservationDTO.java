package com.example.demo.models.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objet de transfert de données (DTO) représentant une réservation.
 *
 * Cette classe est utilisée pour transférer des données concernant une réservation dans le système. Elle est principalement utilisée
 * pour l'échange de données entre les couches de l'application, en particulier pour les réponses d'API ou les échanges de données
 * entre le backend et le frontend.
 *
 * Le DTO contient les informations suivantes sur une réservation : l'identifiant de l'utilisateur (`id_user`), l'identifiant de la
 * boîte réservée (`id_box`) et le statut ou le nombre de réservations (`reservation`).
 *
 * @see Reservation
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {

  /**
   * L'identifiant de l'utilisateur qui a effectué la réservation.
   *
   * Ce champ représente l'identifiant de l'utilisateur qui a effectué la réservation dans le système. Il fait référence à un utilisateur
   * spécifique dans la base de données.
   */
  private Integer id_user;

  /**
   * L'identifiant de la boîte réservée.
   *
   * Ce champ contient l'identifiant de la boîte qui a été réservée par l'utilisateur. Il fait référence à la boîte dans le système.
   */
  private Integer id_box;

  /**
   * Le statut ou le nombre de réservations effectué par l'utilisateur.
   *
   * Ce champ représente le statut de la réservation, qui pourrait être un indicateur numérique, par exemple, du nombre de réservations
   * effectuées pour cette boîte.
   */
  private int reservation;
}
