package com.stdevsec.Inventario.service;

import com.stdevsec.Inventario.entity.Producto;
import com.stdevsec.Inventario.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ProductosService{
    @Autowired
    private ProductosRepository productosRepository;

    //find all
    public List<Producto> findAll(){
        return productosRepository.findAll();
    }
    //find by id
    public Optional<Producto> findById(Long id){
        return productosRepository.findById(id);
    }
    //save
    public Producto save(Producto producto){
        return productosRepository.save(producto);
    }
    //edit
    public Producto update(Producto producto){
        return productosRepository.save(producto);
    }
    //delete
    public void delete(Producto producto){
        productosRepository.delete(producto);
    }

}
