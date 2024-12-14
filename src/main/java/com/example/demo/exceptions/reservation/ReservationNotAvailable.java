package com.example.demo.exceptions.reservation;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="La réservation n'est pas disponible")
public class ReservationNotAvailable extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 1L;

  public ReservationNotAvailable(String message) {
    super("La réservation n'est pas disponible");
  }
}
