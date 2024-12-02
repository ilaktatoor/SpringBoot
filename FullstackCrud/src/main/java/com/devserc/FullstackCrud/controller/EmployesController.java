package com.devserc.FullstackCrud.controller;

import com.devserc.FullstackCrud.entity.Employe;
import com.devserc.FullstackCrud.service.EmployesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class EmployesController {
    @Autowired
    private EmployesService service;

    //get all employees
    @GetMapping("/employees")
    public List<Employe> getAllEmployees(){
      return service.findAll();
    }
    //find by id
    @GetMapping("/{id}")
    public Optional<Employe> findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    // create an employee
    @PostMapping
    public Employe save(@RequestBody Employe employe){
        return service.save(employe);
    }

    //edit employee info
    @PutMapping
    public Employe edit(@RequestBody Employe employe){
        return service.save(employe);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }
}
