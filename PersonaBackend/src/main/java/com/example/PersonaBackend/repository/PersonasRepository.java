package com.example.PersonaBackend.repository;

import com.example.PersonaBackend.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Persona,Long> {
}
