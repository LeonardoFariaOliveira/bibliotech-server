package com.example.bibliotech.commands.itemEmprestimo;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.models.ItemEmprestimo;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.ItemEmprestimoProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class CreateItemEmprestimo implements ICommand, Observer {

    @Autowired
    ItemEmprestimoProvider itemEmprestimoProvider;

    @Override
    public void execute(int id, Object itemEmprestimo) {
        
        this.itemEmprestimoProvider.create((ItemEmprestimo) itemEmprestimo);

    }

    @Override
    public void update(Observable o, Object arg) {
        
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");

    }
    
}
