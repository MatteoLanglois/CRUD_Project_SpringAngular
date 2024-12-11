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
 * Objet de transfert de données (DTO) représentant une boîte.
 *
 * Cette classe est utilisée pour transférer des données concernant une boîte dans le système. Elle est utilisée principalement
 * pour l'échange de données entre les couches de l'application, en particulier pour les réponses d'API ou les échanges de données
 * entre le backend et le frontend.
 *
 * Le DTO contient les informations suivantes sur une boîte : son identifiant (`id`), son nom (`nom`), sa quantité disponible
 * (`quantite`), sa description (`description`) et un point géographique (`point_geo`) qui pourrait indiquer sa localisation.
 *
 * @see
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BoxDTO {

  /**
   * L'identifiant unique de la boîte.
   *
   * Ce champ représente l'identifiant de la boîte dans le système. Il est utilisé pour référencer la boîte de manière unique.
   */
  private Integer id;

  /**
   * Le nom de la boîte.
   *
   * Ce champ contient le nom descriptif de la boîte. Cela peut inclure des informations sur le type de boîte ou son usage.
   */
  private String nom;

  /**
   * La quantité disponible de la boîte.
   *
   * Ce champ représente le nombre de boîtes disponibles dans le système. Il indique la quantité de stock restant pour cette boîte.
   */
  private Integer quantite;

  /**
   * La description de la boîte.
   *
   * Ce champ contient des informations supplémentaires sur la boîte, comme sa taille, son utilisation ou toute autre caractéristique.
   */
  private String description;

  /**
   * Le point géographique de la boîte.
   *
   * Ce champ contient des informations géographiques sous forme de coordonnées ou d'une autre notation pour indiquer l'emplacement
   * de la boîte, par exemple un GPS ou une adresse.
   */
  private String point_geo;
}
