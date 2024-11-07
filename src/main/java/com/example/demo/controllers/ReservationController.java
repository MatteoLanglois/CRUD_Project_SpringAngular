package com.example.demo.controllers;

import com.example.demo.models.Reservation;
import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Mapper.ReservationMapper;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservationController {
  @Autowired
  private ReservationService reservationService;

  @GetMapping(value = "/reservation/{reservationId}")
  public ReservationDTO getReservation(@PathVariable("reservationId") Integer reservationId) {
    return ReservationMapper.INSTANCE.toDTO(reservationService.getById(reservationId));
  }

  @GetMapping(value = "/reservations")
  public ArrayList<ReservationDTO> getAll() {
    ArrayList<ReservationDTO> reservationsDTO = new ArrayList<>();
    for (Reservation reservation : reservationService.getAll()) {
      reservationsDTO.add(ReservationMapper.INSTANCE.toDTO(reservation));
    }
    return reservationsDTO;
  }

  @PostMapping(value = "/reservation")
  public ReservationDTO addReservation(@RequestBody Reservation reservation) {
    return ReservationMapper.INSTANCE.toDTO(reservationService.create(reservation));
  }

  @PostMapping(value = "/reservation/{reservationId}")
  public ReservationDTO updateReservation(@PathVariable("reservationId") Integer reservationId) {
    return ReservationMapper.INSTANCE.toDTO(reservationService.getById(reservationId));
  }

  @DeleteMapping(value = "/reservation/{reservationId}")
  public void deleteReservation(@PathVariable("reservationId") Integer reservationId) {
    reservationService.delete(reservationId);
  }
}