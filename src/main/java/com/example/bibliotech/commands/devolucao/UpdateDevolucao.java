package com.example.bibliotech.commands.devolucao;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.Devolucao;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.DevolucaoProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class UpdateDevolucao implements ICommand, Observer {

  
    @Autowired
    DevolucaoProvider devolucaoProvider;

    @Override
    public void execute(int id, Object devolucao) {
     
        this.devolucaoProvider.update(id, (Devolucao) devolucao);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");
        
    }
    
}
