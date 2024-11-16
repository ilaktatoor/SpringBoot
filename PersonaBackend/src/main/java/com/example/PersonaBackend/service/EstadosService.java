package com.example.PersonaBackend.service;

import com.example.PersonaBackend.entity.Estado;
import com.example.PersonaBackend.repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadosService{

    @Autowired
    private EstadosRepository estadosRepository;

    public Page<Estado> getAllEstados(Integer page, Integer size, Boolean enablePagination){
        return estadosRepository.findAll(enablePagination ? PageRequest.of(page,size) : Pageable.unpaged());
    }

    public List<Estado> getAllByPaisId(Long id){
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estados = estadosRepository.findAll();
        for (int i=0;i<estados.size();i++){
            if (estados.get(i).getPais().getId()==id){
                estadosRespuesta.add(estados.get(i));
            }
        }
        return estadosRespuesta;
    }
}
