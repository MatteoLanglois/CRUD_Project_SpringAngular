package com.example.demo.controllers;

import com.example.demo.models.Reservation;
import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Mapper.ReservationMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservationController {
  @GetMapping(value = "/reservation/{reservationId}")
  public ReservationDTO getReservation(@PathVariable("reservationId") Integer reservationId) {
    return new ReservationDTO();
  }

  @GetMapping(value = "/reservations")
  public ArrayList<ReservationDTO> getAll() {
    ArrayList<ReservationDTO> reservations = new ArrayList<>();
    reservations.add(new ReservationDTO());
    reservations.add(new ReservationDTO());
    reservations.add(new ReservationDTO());
    reservations.add(new ReservationDTO());
    reservations.add(new ReservationDTO());
    return reservations;
  }

  @PostMapping(value = "/reservation")
  public ReservationDTO addReservation(@RequestBody Reservation reservation) {
    return ReservationMapper.INSTANCE.toDTO(reservation);
  }

  @PostMapping(value = "/reservation/{reservationId}")
  public ReservationDTO updateReservation(@PathVariable("reservationId") Integer reservationId) {
    return new ReservationDTO();
  }

  @DeleteMapping(value = "/reservation/{reservationId}")
  public void deleteReservation(@PathVariable("reservationId") Integer reservationId) {
  }
}