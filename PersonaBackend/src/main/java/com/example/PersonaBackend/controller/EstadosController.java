package com.example.PersonaBackend.controller;

import com.example.PersonaBackend.entity.Estado;
import com.example.PersonaBackend.service.EstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadosController {

    @Autowired
    private EstadosService estadosService;

    @GetMapping
    public ResponseEntity<Page<Estado>>getAllEstados(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(required = false, defaultValue = "10") Integer size,
                                                     @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){

        return ResponseEntity.ok(estadosService.getAllEstados(page, size, enablePagination));
    }



    @GetMapping("/{id}")
    private ResponseEntity<List<Estado>> getAllByPaisId(@PathVariable("id") Long id){
        return ResponseEntity.ok(estadosService.getAllByPaisId(id));
    }
}
