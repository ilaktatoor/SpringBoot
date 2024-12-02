package com.stdevsec.Inventario.service;

import com.stdevsec.Inventario.entity.Venta;
import com.stdevsec.Inventario.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService {
    @Autowired
    private VentasRepository repository;

    // find all
    public List<Venta> findAll(){
        return  repository.findAll();
    }
    // find by id
    public Optional<Venta> findById(Long id){
        return repository.findById(id);
    }
    // save/ each time a ventas is created, the amout of the product on the inventory has to decress depending on the amout purched
    public Venta save(Venta venta){
         InventariosService inventariosService = new InventariosService();
            inventariosService.existenciasUpdate(venta.getId(),venta.getCantidad());
            return null;
    }
    // edit
    // delete
}
