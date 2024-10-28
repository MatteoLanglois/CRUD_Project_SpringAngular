package com.example.demo.services;

import com.example.demo.models.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

}
