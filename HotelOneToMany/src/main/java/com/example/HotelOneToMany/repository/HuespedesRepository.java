package com.example.HotelOneToMany.repository;

import com.example.HotelOneToMany.entity.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedesRepository extends JpaRepository<Huesped,Long> {
}
