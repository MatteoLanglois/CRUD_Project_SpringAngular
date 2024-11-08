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
 * Objet de transfert de données (DTO) représentant un utilisateur.
 *
 * Cette classe est utilisée pour transférer des données concernant un utilisateur dans le système. Elle est principalement utilisée
 * pour l'échange de données entre les couches de l'application, en particulier pour les réponses d'API ou les échanges de données
 * entre le backend et le frontend.
 *
 * Le DTO contient les informations suivantes sur un utilisateur : l'identifiant de l'utilisateur (`id`), le nom (`nom`), le prénom
 * (`prenom`), l'adresse e-mail (`mail`), le mot de passe (`password`), et le nom d'utilisateur (`username`).
 *
 * @see User
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

  /**
   * L'identifiant de l'utilisateur.
   *
   * Ce champ représente l'identifiant unique de l'utilisateur dans le système. Il est généralement utilisé pour retrouver un utilisateur
   * spécifique dans la base de données.
   */
  private Integer id;

  /**
   * Le nom de l'utilisateur.
   *
   * Ce champ contient le nom de l'utilisateur dans le système. Il est utilisé pour identifier l'utilisateur dans l'application.
   */
  private String nom;

  /**
   * Le prénom de l'utilisateur.
   *
   * Ce champ contient le prénom de l'utilisateur dans le système. Il est utilisé pour identifier l'utilisateur dans l'application.
   */
  private String prenom;

  /**
   * L'adresse e-mail de l'utilisateur.
   *
   * Ce champ contient l'adresse e-mail de l'utilisateur. Il est généralement utilisé pour la communication avec l'utilisateur et pour
   * l'authentification dans le système.
   */
  private String mail;

  /**
   * Le mot de passe de l'utilisateur.
   *
   * Ce champ contient le mot de passe de l'utilisateur, utilisé pour l'authentification. Ce champ devrait être stocké de manière
   * sécurisée dans la base de données.
   */
  private String password;

  /**
   * Le nom d'utilisateur de l'utilisateur.
   *
   * Ce champ contient le nom d'utilisateur de l'utilisateur. Ce nom est souvent utilisé comme identifiant unique pour l'utilisateur dans
   * le système, en plus de l'adresse e-mail.
   */
  private String username;
}
