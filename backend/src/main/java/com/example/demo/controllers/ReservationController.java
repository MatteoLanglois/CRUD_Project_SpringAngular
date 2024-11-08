package com.example.demo.controllers;

import com.example.demo.models.Box;
import com.example.demo.models.DTO.ReservationDTO;
import com.example.demo.models.Mapper.ReservationMapper;
import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import com.example.demo.models.User;
import com.example.demo.services.BoxService;
import com.example.demo.services.ReservationService;
import com.example.demo.services.UserService;
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
  private ReservationMapper reservationMapper;
  @Autowired
  private UserService userService;
  @Autowired
  private BoxService boxService;

  @GetMapping(value = "/reservations/boxes/{boxId}/users/{userId}")
  public ReservationDTO getReservation(@PathVariable("boxId") Integer boxId, @PathVariable("userId") Integer userId) {
    User user = userService.getById(userId);
    Box box = boxService.getById(boxId);
    return reservationMapper.toDTO(reservationService.getById(new ReservationId(user, box)));
  }

  @GetMapping(value = "/reservations")
  public ArrayList<ReservationDTO> getAll() {
    ArrayList<ReservationDTO> reservationsDTO = new ArrayList<>();
    for (Reservation reservation : reservationService.getAll()) {
      reservationsDTO.add(reservationMapper.toDTO(reservation));
    }
    return reservationsDTO;
  }

  @PostMapping(value = "/reservations")
  public ResponseEntity<ReservationDTO> addReservation(@RequestBody Reservation reservation) {
    try {
      return ResponseEntity.ok(reservationMapper.toDTO(reservationService.create(reservation)));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping(value = "/reservations/boxes/{boxId}/users/{userId}")
  public ReservationDTO updateReservation(@PathVariable("boxId") Integer boxId,
                                          @PathVariable("userId") Integer userId,
                                          @RequestBody Reservation reservation) {
    Box box = boxService.getById(boxId);
    User user = userService.getById(userId);
    return reservationMapper.toDTO(reservationService.update(reservation,
          new ReservationId(user, box)));
  }

  @DeleteMapping(value = "/reservations/boxes/{boxId}/users/{userId}")
  public void deleteReservation(@PathVariable("boxId") Integer boxId,
                                @PathVariable("userId") Integer userId) {
    Box box = boxService.getById(boxId);
    User user = userService.getById(userId);
    reservationService.delete(new ReservationId(user, box));
  }
}