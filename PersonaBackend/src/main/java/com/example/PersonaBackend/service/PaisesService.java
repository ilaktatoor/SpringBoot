package com.example.PersonaBackend.service;

import com.example.PersonaBackend.entity.Pais;
import com.example.PersonaBackend.repository.PaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisesService{

    @Autowired
    private PaisesRepository paisesRepository;

    public Page<Pais> getAllPaises(Integer page, Integer size, Boolean enablePagination){
        return paisesRepository.findAll(enablePagination ? PageRequest.of(page,size) : Pageable.unpaged());
    }
}
