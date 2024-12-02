package com.stdevsec.microservicios_usuarios.service;

import com.stdevsec.microservicios_usuarios.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceImpl<E,R extends JpaRepository<E,Long>> implements CommonService<E>{

    @Autowired
    private R repository;

    @Transactional(readOnly = true)
    @Override
    public Iterable<E> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
