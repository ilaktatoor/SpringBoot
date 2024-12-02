package com.stdevsec.microservicios_usuarios.service;

import com.stdevsec.microservicios_usuarios.entity.Alumno;
import com.stdevsec.microservicios_usuarios.repository.AlumnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnosServiceImpl implements AlumnosService{

    @Autowired
    private AlumnosRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Iterable<Alumno> findAll(){
        return repository.findAllByOrderByIdAsc();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Alumno> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
