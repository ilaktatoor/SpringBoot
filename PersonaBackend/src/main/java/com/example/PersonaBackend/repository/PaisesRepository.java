package com.example.PersonaBackend.repository;

import com.example.PersonaBackend.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesRepository extends JpaRepository<Pais,Long> {

}
