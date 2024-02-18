package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.devolucao.CreateDevolucao;
import com.example.bibliotech.commands.devolucao.DeleteDevolucao;
import com.example.bibliotech.commands.devolucao.UpdateDevolucao;
import com.example.bibliotech.models.Devolucao;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.DevolucaoProvider;

@Service
public class DevolucaoService{

    @Autowired 
    CreateDevolucao createDevolucao;

    @Autowired 
    UpdateDevolucao updateDevolucao;

    @Autowired 
    DeleteDevolucao deleteDevolucao;

    @Autowired
    DevolucaoProvider devolucaoProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Devolucao Devolucao){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createDevolucao);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(Devolucao == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createDevolucao.execute(id, Devolucao);
                break;

            case "update":
                this.updateDevolucao.execute(id, Devolucao);
                break;

            case "delete":
                this.deleteDevolucao.execute(id, Devolucao);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Devolucao> getAllDevolucaos(){
        return this.devolucaoProvider.getAll();
    }

    public Devolucao getDevolucaoById(int id){
        return this.devolucaoProvider.getOneById(id);
    }
    

}
