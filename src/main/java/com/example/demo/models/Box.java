package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
 * Classe représentant une boîte dans la base de données.
 * Elle est mappée sur la table "boite" grâce à l'annotation {@link Table}.
 * Utilise l'API Jakarta Persistence pour la gestion ORM, et Lombok pour simplifier le code de gestion des getters, setters, et constructeurs.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Entity} : Indique que cette classe est une entité JPA</li>
 *     <li>{@link Table} : Définit la table associée à cette entité, nommée "boite"</li>
 *     <li>{@link Id} : Spécifie le champ de clé primaire</li>
 *     <li>{@link GeneratedValue} : La clé primaire est générée automatiquement</li>
 *     <li>{@link NonNull} : Indique les champs obligatoires pour cette entité</li>
 * </ul>
 *
 * <p>Généré par Lombok :
 * <ul>
 *     <li>{@link Getter} et {@link Setter} : Fournissent automatiquement les accesseurs et mutateurs pour chaque champ</li>
 *     <li>{@link ToString} : Génère une méthode toString() pour un affichage facile de l'objet</li>
 *     <li>{@link Builder} : Permet la construction d'une instance de {@code Box} via un pattern de type Builder</li>
 *     <li>{@link AllArgsConstructor} et {@link NoArgsConstructor} : Fournissent des constructeurs pour cette classe</li>
 * </ul>
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "boite")
public class Box {

  /**
   * Identifiant unique de la boîte.
   * Généré automatiquement avec la stratégie {@link GenerationType#IDENTITY}.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Nom de la boîte.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String nom;

  /**
   * Quantité disponible dans la boîte.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private Integer quantite;

  /**
   * Description de la boîte.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String description;

  /**
   * Point géographique associé à la boîte.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String point_geo;
}
