package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.debito.CreateDebito;
import com.example.bibliotech.commands.debito.DeleteDebito;
import com.example.bibliotech.commands.debito.UpdateDebito;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Debito;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.DebitoProvider;

@Service
public class DebitoService{

    @Autowired 
    CreateDebito createDebito;

    @Autowired 
    UpdateDebito updateDebito;

    @Autowired 
    DeleteDebito deleteDebito;

    @Autowired
    DebitoProvider debitoProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Debito debito){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createDebito);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(debito == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createDebito.execute(id, debito);
                break;

            case "update":
                this.updateDebito.execute(id, debito);
                break;

            case "delete":
                this.deleteDebito.execute(id, debito);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Debito> getAllDebitos(){
        return this.debitoProvider.getAll();
    }

    public Debito getDebitoById(int id){
        return this.debitoProvider.getOneById(id);
    }

    public Debito getDebitoByAluno(Aluno aluno){
        return this.debitoProvider.getOneByAluno(aluno);
    }
    

}
