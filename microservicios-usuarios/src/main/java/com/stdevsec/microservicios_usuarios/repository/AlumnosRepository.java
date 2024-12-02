package com.stdevsec.microservicios_usuarios.repository;

import com.stdevsec.microservicios_usuarios.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumno, Long> {
    public Iterable<Alumno> findAllByOrderByIdAsc();
}
