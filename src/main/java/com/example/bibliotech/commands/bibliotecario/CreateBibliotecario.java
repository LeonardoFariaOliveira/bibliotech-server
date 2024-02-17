package com.example.bibliotech.commands.bibliotecario;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Bibliotecario;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.BibliotecarioProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateBibliotecario implements ICommand, Observer {

    @Autowired
    BibliotecarioProvider bibliotecarioProvider;

    @Override
    public void execute(int id, Object bibliotecario) {
        
        this.bibliotecarioProvider.create((Bibliotecario) bibliotecario);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
