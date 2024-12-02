package com.stdevsec.microservicios_usuarios.controller;

import com.stdevsec.microservicios_usuarios.dto.AlumnoDto;
import com.stdevsec.microservicios_usuarios.entity.Alumno;
import com.stdevsec.microservicios_usuarios.service.AlumnosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Angular's origin
@RequestMapping("/api/alumnos")
public class AlumnosController {
    @Autowired
    private AlumnosService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        Optional<Alumno> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AlumnoDto alumnoDto, BindingResult result) {
        if(result.hasErrors()){
            return this.validar(result);
        }
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEmail(alumnoDto.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable(name = "id") Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno alumnodb = o.get();
        alumnodb.setNombre(alumno.getNombre());
        alumnodb.setApellido(alumno.getApellido());
        alumnodb.setEmail(alumno.getEmail());

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnodb));
        } catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict detected: The resource was modified by another transaction. Please try again.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    protected ResponseEntity<?>validar(BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(),"El campo "+err.getField()+" "+err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
