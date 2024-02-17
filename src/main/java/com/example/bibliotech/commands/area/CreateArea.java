package com.example.bibliotech.commands.area;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Area;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AreaProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateArea implements ICommand, Observer {

    @Autowired
    AreaProvider areaProvider;

    @Override
    public void execute(int id, Object area) {
        
        this.areaProvider.create((Area) area);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
