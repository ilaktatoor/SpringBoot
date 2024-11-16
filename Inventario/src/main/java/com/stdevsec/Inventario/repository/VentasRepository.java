package com.stdevsec.Inventario.repository;

import com.stdevsec.Inventario.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository <Venta, Long> {
}
