package com.stdevsec.Inventario.repository;

import com.stdevsec.Inventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventariosRepository extends JpaRepository<Inventario, Long> {
}
