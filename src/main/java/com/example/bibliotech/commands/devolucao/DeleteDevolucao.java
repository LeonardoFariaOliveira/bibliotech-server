package com.example.bibliotech.commands.devolucao;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.DevolucaoProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class DeleteDevolucao implements ICommand, Observer{

    @Autowired
    DevolucaoProvider DevolucaoProvider;

    @Override
    public void execute(int id, Object object) {
       this.DevolucaoProvider.delete(id);
    }

    @Override
    public void update(Observable o, Object arg) {
       
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");
    }
    
}
