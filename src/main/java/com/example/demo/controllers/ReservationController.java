package com.example.demo.controllers;

import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Mapper.ReservationMapper;
import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import com.example.demo.services.ReservationService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
  @Autowired
  private ReservationService reservationService;

  @Autowired
  private ReservationMapper ReservationMapper;

  @GetMapping(value = "/reservation/{reservationId}")
  public ReservationDTO getReservation(@PathVariable("reservationId") ReservationId reservationId) {
    return ReservationMapper.toDTO(reservationService.getById(reservationId));
  }

  @GetMapping(value = "/reservations")
  public ArrayList<ReservationDTO> getAll() {
    ArrayList<ReservationDTO> reservationsDTO = new ArrayList<>();
    for (Reservation reservation : reservationService.getAll()) {
      reservationsDTO.add(ReservationMapper.toDTO(reservation));
    }
    return reservationsDTO;
  }

  @PostMapping(value = "/reservation")
  public ResponseEntity<ReservationDTO> addReservation(@RequestBody Reservation reservation) {
    try {
      return ResponseEntity.ok(ReservationMapper.toDTO(reservationService.create(reservation)));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping(value = "/reservation/{reservationId}")
  public ReservationDTO updateReservation(@PathVariable("reservationId") ReservationId reservationId,
                                          @RequestBody Reservation reservation) {
      return ReservationMapper.toDTO(reservationService.update(reservation, reservationId));
  }

  @DeleteMapping(value = "/reservation/{reservationId}")
  public void deleteReservation(@PathVariable("reservationId") ReservationId reservationId) {
      reservationService.delete(reservationId);
  }
}