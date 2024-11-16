package com.example.HotelOneToMany.controller;

import com.example.HotelOneToMany.entity.Huesped;
import com.example.HotelOneToMany.service.HuespedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huesped")
public class HuespedesController {

    @Autowired
    private HuespedesService huespedesService;

    //FindAll
    @GetMapping
    public List<Huesped> findAllHuesped(){
        return huespedesService.getAllHuespedes();
    }
    //CrearHuesped
    @PostMapping
    public Huesped crearHuesped(@RequestBody Huesped huesped){
        return huespedesService.createHuesped(huesped);
    }
    //EditHuesped
    @PostMapping("/edit/{id}")
    public Huesped editarHuesped(@RequestBody Huesped huesped,@PathVariable("id") Long id){
        huesped.setId(id);
        return huespedesService.editHuesped(huesped);
    }
    //DeleteById
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        huespedesService.deleteById(id);
    }

}
