package com.stdevsec.microservicios_usuarios.service;

import com.stdevsec.microservicios_usuarios.entity.Alumno;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AlumnosService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
}
