package com.example.demo.exceptions.reservation;

import java.io.Serial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "La réservation n'a pas été trouvée")
public class ReservationNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ReservationNotFoundException() {
        super("La réservation n'a pas été trouvée");
    }
}