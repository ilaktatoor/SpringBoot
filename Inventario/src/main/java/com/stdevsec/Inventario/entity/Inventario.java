package com.stdevsec.Inventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "inventario",uniqueConstraints = {
        @UniqueConstraint(name = "id_inventario_UK", columnNames = {"id_producto"})
})
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inventario")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto",foreignKey = @ForeignKey(name = "id_producto_FK"))
    private Producto producto;

    @Column(name = "precionUnidad", nullable = false, precision = 19, scale = 2)
    private BigDecimal precioUnidad;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
