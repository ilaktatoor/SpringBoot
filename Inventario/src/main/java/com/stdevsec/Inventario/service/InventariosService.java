package com.stdevsec.Inventario.service;

import com.stdevsec.Inventario.entity.Inventario;
import com.stdevsec.Inventario.repository.InventariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventariosService {
    @Autowired
    private InventariosRepository repository;

    //find all
    public List<Inventario> findAll(){
        return repository.findAll();
    }
    //find by id
    public Optional<Inventario> findById(Long id){
        return repository.findById(id);
    }
    // save
    public Inventario save(Inventario inventario){
        return repository.save(inventario);
    }
    // update
    public Inventario update(Inventario inventario){
        return repository.save(inventario);
    }

    // Edit producto en inventario
    public void existenciasUpdate(Long id, Integer nuevaCantidad){
        Optional<Inventario> inventarioOpt = repository.findById(id);

        if(inventarioOpt.isEmpty()){
            throw new RuntimeException("Inventario con ID " + id + " no encontrado");
        }

        Inventario inventario = inventarioOpt.get();
        inventario.setCantidad(nuevaCantidad); // Actualizar solo el campo "cantidad"
        repository.save(inventario); // Guardar los cambios
    }
}
