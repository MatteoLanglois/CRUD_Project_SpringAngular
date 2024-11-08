package com.example.demo.models.Mapper;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.BoxDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface de mappage pour convertir des objets de type {@link Box} en {@link BoxDTO} et inversement.
 * Utilise MapStruct pour générer automatiquement le code de mappage entre l'entité et le DTO.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Mapper} : Indique que cette interface est un mapper MapStruct, avec un modèle de composant défini sur "spring" pour être géré par le contexte Spring.</li>
 * </ul>
 *
 * <p>Méthodes de conversion :
 * <ul>
 *     <li>{@link #toDTO(Box)} : Convertit une entité {@link Box} en un objet {@link BoxDTO}.</li>
 *     <li>{@link #toEntity(BoxDTO)} : Convertit un objet {@link BoxDTO} en entité {@link Box}.</li>
 * </ul>
 */
@Mapper(componentModel = "spring")
public interface BoxMapper {

  /**
   * Instance du mapper pour fournir une implémentation générée automatiquement par MapStruct.
   */
  BoxMapper INSTANCE = Mappers.getMapper(BoxMapper.class);

  /**
   * Convertit une entité {@link Box} en un objet {@link BoxDTO}.
   *
   * @param box l'entité {@link Box} à convertir
   * @return un objet {@link BoxDTO} contenant les données de l'entité
   */
  BoxDTO toDTO(Box box);

  /**
   * Convertit un objet {@link BoxDTO} en entité {@link Box}.
   *
   * @param boxDTO l'objet {@link BoxDTO} à convertir
   * @return une entité {@link Box} contenant les données du DTO
   */
  Box toEntity(BoxDTO boxDTO);

}
