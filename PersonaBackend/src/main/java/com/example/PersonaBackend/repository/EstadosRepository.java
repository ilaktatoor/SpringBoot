package com.example.PersonaBackend.repository;

import com.example.PersonaBackend.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estado,Long> {
}
