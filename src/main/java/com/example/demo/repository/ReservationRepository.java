package com.example.demo.repository;


import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
  @Query("SELECT SUM(r.reservation) FROM Reservation r WHERE r.box.id = :boxId")
  Integer findTotalReservationByBoxId(Integer boxId);
}
