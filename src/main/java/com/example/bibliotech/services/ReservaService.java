package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.reserva.CreateReserva;
import com.example.bibliotech.commands.reserva.DeleteReserva;
import com.example.bibliotech.commands.reserva.UpdateReserva;
import com.example.bibliotech.models.Reserva;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.ReservaProvider;

@Service
public class ReservaService{

    @Autowired 
    CreateReserva createReserva;

    @Autowired 
    UpdateReserva updateReserva;

    @Autowired 
    DeleteReserva deleteReserva;

    @Autowired
    ReservaProvider reservaProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Reserva Reserva){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createReserva);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(Reserva == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createReserva.execute(id, Reserva);
                break;

            case "update":
                this.updateReserva.execute(id, Reserva);
                break;

            case "delete":
                this.deleteReserva.execute(id, Reserva);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Reserva> getAllReservas(){
        return this.reservaProvider.getAll();
    }

    public Reserva getReservaById(int id){
        return this.reservaProvider.getOneById(id);
    }
    

}
