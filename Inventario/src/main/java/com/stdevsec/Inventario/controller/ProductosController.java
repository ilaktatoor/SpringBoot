package com.stdevsec.Inventario.controller;

import com.stdevsec.Inventario.entity.Producto;
import com.stdevsec.Inventario.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductosController {
    @Autowired
    private ProductosService service;

    // find all
    @GetMapping
    public List<Producto> findAll(){
        return service.findAll();
    }
    //find by id
    @GetMapping(value = "{/id}")
    public ResponseEntity<Optional<Producto>> findById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    // save
    @PostMapping
    public ResponseEntity<Producto> save(Producto producto){
        return ResponseEntity.status(HttpStatus.OK).body(service.save(producto));
    }
    // update
    @PutMapping
    public ResponseEntity<Producto> update(Producto producto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(producto));
    }
    // delete
    @DeleteMapping
    public void delte(Producto producto){
        service.delete(producto);
        ResponseEntity.ok(service.findById(producto.getId()));
    }
}
