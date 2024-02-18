package com.example.bibliotech.commands.debito;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Debito;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.DebitoProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateDebito implements ICommand, Observer {

    @Autowired
    DebitoProvider debitoProvider;

    @Override
    public void execute(int id, Object debito) {
        
        this.debitoProvider.create((Debito) debito);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
