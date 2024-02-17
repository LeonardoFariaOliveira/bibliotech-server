package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Reserva;
import com.example.bibliotech.repositories.ReservaRepository;

@Service
public class ReservaProvider implements IGenericDao<Reserva>{

    @Autowired
    ReservaRepository reservaRepository;


    @Override
    public void create(Reserva object) {
    

        this.reservaRepository.save(object);

    }

    @Override
    public List<Reserva> getAll() {
        return this.reservaRepository.findAll();
    }

    @Override
    public Reserva getOneById(int id) {
        
        var reserva = this.reservaRepository.findById(id);
        if(reserva.isEmpty()){
            throw new Error("Reserva não existe");
        }
        return reserva.get();
        
    }

    @Override
    public void update(int id, Reserva object) {
       
      
        var reserva = this.reservaRepository.findById(id);
        if(reserva.isEmpty()){
            throw new Error("Reserva não existe");
        }
      
        reserva.get().setData(object.getData());
        this.reservaRepository.save(reserva.get());
        
    }

    @Override
    public void delete(int id) {

        var reserva = this.reservaRepository.findById(id);
        if(reserva.isEmpty()){
            throw new Error("Reserva não existe");
        }
        
        this.reservaRepository.deleteById(id);
        
    }

    
}
