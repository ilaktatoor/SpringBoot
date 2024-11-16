package com.example.HotelOneToMany.service;

import com.example.HotelOneToMany.entity.Huesped;
import com.example.HotelOneToMany.repository.HuespedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuespedesService {

    @Autowired
    private HuespedesRepository huespedesRepository;

    //findAll
    public List<Huesped> getAllHuespedes(){
        return huespedesRepository.findAll();
    }

    //Create
    public Huesped createHuesped(Huesped huesped){
        return huespedesRepository.save(huesped);
    }

    //Edit
    public Huesped editHuesped(Huesped huesped){
        return huespedesRepository.save(huesped);
    }

    //DeletebyId
    public void deleteById(Long id){
        huespedesRepository.deleteById(id);
    }

}
