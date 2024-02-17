package com.example.bibliotech.commands.reserva;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Reserva;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.ReservaProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateReserva implements ICommand, Observer {

    @Autowired
    ReservaProvider reservaProvider;

    @Override
    public void execute(int id, Object reserva) {
        
        this.reservaProvider.create((Reserva) reserva);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
