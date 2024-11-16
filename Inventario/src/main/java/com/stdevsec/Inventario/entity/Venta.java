package com.stdevsec.Inventario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "venta",uniqueConstraints = {
        @UniqueConstraint(name = "id_venta_UK", columnNames = {"id_producto"})
})
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_venta")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto",foreignKey = @ForeignKey(name = "id_producto_FK"))
    private Producto producto;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "monto", precision = 19, scale = 2, nullable = false)
    private BigInteger monto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
