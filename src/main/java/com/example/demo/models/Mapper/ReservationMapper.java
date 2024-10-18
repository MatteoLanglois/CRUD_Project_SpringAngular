package com.example.demo.models.Mapper;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Reservation;

public interface ReservationMapper {
  ReservationDTO toDTO(Reservation reservation);

  Reservation toEntity(ReservationDTO reservationDTO);
}
