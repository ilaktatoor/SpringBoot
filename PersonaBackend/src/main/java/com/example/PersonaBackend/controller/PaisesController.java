package com.example.PersonaBackend.controller;

import com.example.PersonaBackend.entity.Pais;
import com.example.PersonaBackend.service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisesController {

    @Autowired
    private PaisesService paisesService;

    @GetMapping
    public ResponseEntity<Page<Pais>>getAllPaises(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                   @RequestParam(required = false, defaultValue = "10") Integer size,
                                                   @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){

        return ResponseEntity.ok(paisesService.getAllPaises(page, size, enablePagination));
    }
}
