package com.stdevsec.Inventario.repository;

import com.stdevsec.Inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository  extends JpaRepository<Producto, Long> {

}
