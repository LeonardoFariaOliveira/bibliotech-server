package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.autor.CreateAutor;
import com.example.bibliotech.commands.autor.DeleteAutor;
import com.example.bibliotech.commands.autor.UpdateAutor;
import com.example.bibliotech.models.Autor;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AutorProvider;

@Service
public class AutorService{

    @Autowired 
    CreateAutor createAutor;

    @Autowired 
    UpdateAutor updateAutor;

    @Autowired 
    DeleteAutor deleteAutor;

    @Autowired
    AutorProvider autorProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Autor Autor){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createAutor);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(Autor == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createAutor.execute(id, Autor);
                break;

            case "update":
                this.updateAutor.execute(id, Autor);
                break;

            case "delete":
                this.deleteAutor.execute(id, Autor);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Autor> getAllAutors(){
        return this.autorProvider.getAll();
    }

    public Autor getAutorById(int id){
        return this.autorProvider.getOneById(id);
    }

    public Autor getAutorByNome(String nome){
        return this.autorProvider.getOneByName(nome);
    }
    
    

}
