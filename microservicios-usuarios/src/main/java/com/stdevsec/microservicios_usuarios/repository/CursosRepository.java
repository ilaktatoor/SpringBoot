package com.stdevsec.microservicios_usuarios.repository;

import com.stdevsec.microservicios_usuarios.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursosRepository extends CrudRepository<Curso, Long> {
}
