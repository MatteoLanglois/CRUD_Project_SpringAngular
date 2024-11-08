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
 * Classe représentant un utilisateur dans la base de données.
 * Elle est mappée sur la table "utilisateur" et contient les informations personnelles de l'utilisateur.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Entity} : Indique que cette classe est une entité JPA.</li>
 *     <li>{@link Table} : Définit la table associée à cette entité, nommée "utilisateur".</li>
 *     <li>{@link Id} : Spécifie le champ de clé primaire.</li>
 *     <li>{@link GeneratedValue} : La clé primaire est générée automatiquement avec la stratégie {@link GenerationType#IDENTITY}.</li>
 *     <li>{@link NonNull} : Indique les champs obligatoires pour cette entité.</li>
 * </ul>
 *
 * <p>Généré par Lombok :
 * <ul>
 *     <li>{@link Getter} et {@link Setter} : Fournissent automatiquement les accesseurs et mutateurs pour chaque champ.</li>
 *     <li>{@link ToString} : Génère une méthode toString() pour un affichage facile de l'objet.</li>
 *     <li>{@link Builder} : Permet la construction d'une instance de {@code User} via un pattern de type Builder.</li>
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
@Table(name = "utilisateur")
public class User {

  /**
   * Identifiant unique de l'utilisateur.
   * Généré automatiquement avec la stratégie {@link GenerationType#IDENTITY}.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * Nom de l'utilisateur.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String nom;

  /**
   * Prénom de l'utilisateur.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String prenom;

  /**
   * Adresse e-mail de l'utilisateur.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String mail;

  /**
   * Mot de passe de l'utilisateur.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String password;

  /**
   * Nom d'utilisateur (username) unique pour l'authentification.
   * Ce champ est obligatoire et ne peut pas être nul.
   */
  @NonNull
  private String username;
}
