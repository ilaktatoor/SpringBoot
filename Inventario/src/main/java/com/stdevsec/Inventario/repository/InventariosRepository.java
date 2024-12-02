package com.stdevsec.Inventario.repository;

import com.stdevsec.Inventario.entity.Inventario;
import com.stdevsec.Inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventariosRepository extends JpaRepository<Inventario, Long> {

}
