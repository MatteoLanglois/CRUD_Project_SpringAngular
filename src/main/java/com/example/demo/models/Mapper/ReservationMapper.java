package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.factory.Mappers;

public interface ReservationMapper {
  ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

  ReservationDTO toDTO(Reservation reservation);

  Reservation toEntity(ReservationDTO reservationDTO);
}
