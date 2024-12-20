package com.example.demo.services;

import com.example.demo.exceptions.reservation.ReservationNotFoundException;
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
        return reservation.orElseThrow(ReservationNotFoundException::new);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation, ReservationId reservationId) {
        Reservation existingReservation = reservationRepository.findById(reservationId).orElseThrow(ReservationNotFoundException::new);
        existingReservation.setReservation(reservation.getReservation());
        existingReservation.setBox(reservation.getBox());
        existingReservation.setUser(reservation.getUser());
        return reservationRepository.save(existingReservation);
    }

    public void delete(ReservationId reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public int getTotalReservationByBoxId(Integer boxId) {
        return Optional.ofNullable(reservationRepository.findTotalReservationByBoxId(boxId)).orElse(0);
    }
}