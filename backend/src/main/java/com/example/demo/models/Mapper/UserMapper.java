package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.UserDTO;
import com.example.demo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface de mappage pour convertir des objets de type {@link User} en {@link UserDTO} et inversement.
 * Utilise MapStruct pour générer automatiquement le code de mappage entre l'entité et le DTO.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Mapper} : Indique que cette interface est un mapper MapStruct, avec un modèle de composant défini sur "spring" pour être géré par le contexte Spring.</li>
 * </ul>
 *
 * <p>Méthodes de conversion :
 * <ul>
 *     <li>{@link #toDTO(User)} : Convertit une entité {@link User} en un objet {@link UserDTO}.</li>
 *     <li>{@link #toEntity(UserDTO)} : Convertit un objet {@link UserDTO} en entité {@link User}.</li>
 * </ul>
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

  /**
   * Instance du mapper pour fournir une implémentation générée automatiquement par MapStruct.
   */
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  /**
   * Convertit une entité {@link User} en un objet {@link UserDTO}.
   *
   * @param user l'entité {@link User} à convertir
   * @return un objet {@link UserDTO} contenant les données de l'entité
   */
  UserDTO toDTO(User user);

  /**
   * Convertit un objet {@link UserDTO} en entité {@link User}.
   *
   * @param userDTO l'objet {@link UserDTO} à convertir
   * @return une entité {@link User} contenant les données du DTO
   */
  User toEntity(UserDTO userDTO);
}

