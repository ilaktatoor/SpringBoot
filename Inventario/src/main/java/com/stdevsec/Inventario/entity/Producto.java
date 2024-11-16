package com.stdevsec.Inventario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_producto")
    private Long id;

    @Column(name="codigo", nullable = false)
    private String codigo;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @Column(name="categoria", nullable = false)
    private String categoria;

    @Column(name="activo", nullable = false)
    private Boolean activo;
}
