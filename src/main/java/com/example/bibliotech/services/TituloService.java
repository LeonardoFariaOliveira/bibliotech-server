package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.titulo.CreateTitulo;
import com.example.bibliotech.commands.titulo.DeleteTitulo;
import com.example.bibliotech.commands.titulo.UpdateTitulo;
import com.example.bibliotech.models.Titulo;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.TituloProvider;

@Service
public class TituloService{

    @Autowired 
    CreateTitulo createTitulo;

    @Autowired 
    UpdateTitulo updateTitulo;

    @Autowired 
    DeleteTitulo deleteTitulo;

    @Autowired
    TituloProvider tituloProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Titulo Titulo){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createTitulo);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(Titulo == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createTitulo.execute(id, Titulo);
                break;

            case "update":
                this.updateTitulo.execute(id, Titulo);
                break;

            case "delete":
                this.deleteTitulo.execute(id, Titulo);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Titulo> getAllTitulos(){
        return this.tituloProvider.getAll();
    }

    public Titulo getTituloById(int id){
        return this.tituloProvider.getOneById(id);
    }
    

}
