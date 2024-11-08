package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ReservationMapper {
  ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

  @Mapping(source = "id_user", target = "id_user")
  @Mapping(source = "id_box", target = "id_box")
  @Mapping(source = "reservation", target = "reservation")
  ReservationDTO toDTO(Reservation reservation);

  @Mapping(source = "id_user", target = "id_user")
  @Mapping(source = "id_box", target = "id_box")
  @Mapping(source = "reservation", target = "reservation")
  Reservation toEntity(ReservationDTO reservationDTO);
}
