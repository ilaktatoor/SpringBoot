package com.devserc.FullstackCrud.service;

import com.devserc.FullstackCrud.entity.Employe;
import com.devserc.FullstackCrud.respository.EmployesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployesService {

    @Autowired
    private EmployesRepository repository;

    public List<Employe> findAll(){
        return repository.findAll();
    }

    public Optional<Employe> findById(Long id){
        return repository.findById(id);
    }

    public Employe save(Employe employe){
        return repository.save(employe);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
