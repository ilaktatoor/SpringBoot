package com.stdevsec.Inventario.controller;

import com.stdevsec.Inventario.entity.Inventario;
import com.stdevsec.Inventario.service.InventariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventariosController {
    @Autowired
    private InventariosService service;

    //find all
    @GetMapping
    public ResponseEntity<List<Inventario>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    //find by id
    @GetMapping("{/id}")
    public ResponseEntity<Optional<Inventario>>findById(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    //save
    @PostMapping
    public ResponseEntity<Inventario> save(Inventario inventario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inventario));
    }
    //edit
    @PutMapping
    public ResponseEntity<Inventario> update(Inventario inventario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(inventario));
    }
}
