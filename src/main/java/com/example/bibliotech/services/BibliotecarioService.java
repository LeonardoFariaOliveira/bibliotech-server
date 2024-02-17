package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.bibliotecario.CreateBibliotecario;
import com.example.bibliotech.commands.bibliotecario.DeleteBibliotecario;
import com.example.bibliotech.commands.bibliotecario.UpdateBibliotecario;
import com.example.bibliotech.models.Bibliotecario;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.BibliotecarioProvider;

@Service
public class BibliotecarioService{

    @Autowired 
    CreateBibliotecario createBibliotecario;

    @Autowired 
    UpdateBibliotecario updateBibliotecario;

    @Autowired 
    DeleteBibliotecario deleteBibliotecario;

    @Autowired
    BibliotecarioProvider bibliotecarioProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Bibliotecario bibliotecario){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createBibliotecario);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(bibliotecario == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createBibliotecario.execute(id, bibliotecario);
                break;

            case "update":
                this.updateBibliotecario.execute(id, bibliotecario);
                break;

            case "delete":
                this.deleteBibliotecario.execute(id, bibliotecario);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Bibliotecario> getAllBibliotecarios(){
        return this.bibliotecarioProvider.getAll();
    }

    public Bibliotecario getBibliotecarioById(int id){
        return this.bibliotecarioProvider.getOneById(id);
    }

    public Bibliotecario getBibliotecarioByEmail(String email){
        return this.bibliotecarioProvider.getOneByEmail(email);
    }
    

}
