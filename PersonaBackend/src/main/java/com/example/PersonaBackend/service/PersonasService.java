package com.example.PersonaBackend.service;

import com.example.PersonaBackend.entity.Persona;
import com.example.PersonaBackend.repository.PersonasRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonasService{

    @Autowired
    private PersonasRepository personasRepository;

    public Page<Persona> findAll(Integer page, Integer size, Boolean enablePagination){
        return personasRepository.findAll(enablePagination ? PageRequest.of(page,size) : Pageable.unpaged());
    }

    public void deletePersona(Persona persona){
        personasRepository.delete(persona);
    }

    public void deleteById(Long id){
        personasRepository.deleteById(id);
    }

    public Persona save(Persona persona) {
        return personasRepository.save(persona);
    }
}
