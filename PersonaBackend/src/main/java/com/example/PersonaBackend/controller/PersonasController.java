package com.example.PersonaBackend.controller;

import com.example.PersonaBackend.entity.Persona;
import com.example.PersonaBackend.service.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @GetMapping
    public ResponseEntity<Page<Persona>>getAllpersona(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10") Integer size,
                                                      @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){

        return ResponseEntity.ok(personasService.findAll(page, size, enablePagination));
    }

    @PutMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        try{
            Persona personaGuardada = personasService.save(persona);
            return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
