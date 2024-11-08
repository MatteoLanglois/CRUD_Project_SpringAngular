package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReservationMapper {

  @Mapping(source = "user.id", target = "id_user")
  @Mapping(source = "box.id", target = "id_box")
  ReservationDTO toDTO(Reservation reservation);

  @Mapping(source = "id_user", target = "user.id")
  @Mapping(source = "id_box", target = "box.id")
  Reservation toEntity(ReservationDTO reservationDTO);
}
