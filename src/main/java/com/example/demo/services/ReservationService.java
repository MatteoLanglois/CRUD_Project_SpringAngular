package com.example.demo.services;

import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import com.example.demo.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation getById(ReservationId reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        return reservation.orElse(null);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation, ReservationId reservationId) {
        Reservation existingReservation = reservationRepository.findById(reservationId).orElse(null);
        if (existingReservation != null) {
            existingReservation.setBox(reservation.getBox());
            existingReservation.setUser(reservation.getUser());
            existingReservation.setReservation(reservation.getReservation());
            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    public void delete(ReservationId reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}