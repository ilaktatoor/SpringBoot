package com.example.HotelOneToMany.service;

import com.example.HotelOneToMany.entity.Reserva;
import com.example.HotelOneToMany.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    //findAll
    public List<Reserva> findAllReservas(){
        return reservasRepository.findAll();
    }
    //CrearReserva
    public Reserva crearReserva(Reserva reserva){
        return reservasRepository.save(reserva);
    }
    //EditarReserva
    public Reserva editarReserva(Reserva reserva){
        return reservasRepository.save(reserva);
    }
    //DeleteById
    public void deleteById(Long id){
        reservasRepository.deleteById(id);
    }
}
