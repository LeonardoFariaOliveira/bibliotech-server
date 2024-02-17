package com.example.bibliotech.commands.autor;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Autor;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AutorProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateAutor implements ICommand, Observer {

    @Autowired
    AutorProvider autorProvider;

    @Override
    public void execute(int id, Object autor) {
        
        this.autorProvider.create((Autor) autor);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
