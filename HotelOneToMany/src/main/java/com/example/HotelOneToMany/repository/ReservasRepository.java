package com.example.HotelOneToMany.repository;

import com.example.HotelOneToMany.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reserva, Long> {
}
