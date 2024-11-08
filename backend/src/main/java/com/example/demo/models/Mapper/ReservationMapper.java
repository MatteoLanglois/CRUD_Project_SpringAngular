package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 * Interface de mappage pour convertir des objets de type {@link Reservation} en {@link ReservationDTO} et inversement.
 * Utilise MapStruct pour générer automatiquement le code de mappage entre l'entité et le DTO.
 *
 * <p>Annotations principales :
 * <ul>
 *     <li>{@link Mapper} : Indique que cette interface est un mapper MapStruct.</li>
 *     <li>{@link Mapping} : Spécifie des mappages personnalisés entre les attributs des classes {@link Reservation} et {@link ReservationDTO}.</li>
 * </ul>
 *
 * <p>Méthodes de conversion :
 * <ul>
 *     <li>{@link #toDTO(Reservation)} : Convertit une entité {@link Reservation} en un objet {@link ReservationDTO}.</li>
 *     <li>{@link #toEntity(ReservationDTO)} : Convertit un objet {@link ReservationDTO} en entité {@link Reservation}.</li>
 * </ul>
 */
@Mapper
public interface ReservationMapper {

  /**
   * Convertit une entité {@link Reservation} en un objet {@link ReservationDTO}.
   *
   * @param reservation l'entité {@link Reservation} à convertir
   * @return un objet {@link ReservationDTO} contenant les données de l'entité
   */
  @Mapping(source = "user.id", target = "id_user")
  @Mapping(source = "box.id", target = "id_box")
  ReservationDTO toDTO(Reservation reservation);

  /**
   * Convertit un objet {@link ReservationDTO} en entité {@link Reservation}.
   *
   * @param reservationDTO l'objet {@link ReservationDTO} à convertir
   * @return une entité {@link Reservation} contenant les données du DTO
   */
  @Mapping(source = "id_user", target = "user.id")
  @Mapping(source = "id_box", target = "box.id")
  Reservation toEntity(ReservationDTO reservationDTO);
}
