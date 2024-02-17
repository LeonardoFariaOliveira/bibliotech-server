package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.livro.CreateLivro;
import com.example.bibliotech.commands.livro.DeleteLivro;
import com.example.bibliotech.commands.livro.UpdateLivro;
import com.example.bibliotech.models.Livro;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.LivroProvider;

@Service
public class LivroService{

    @Autowired 
    CreateLivro createLivro;

    @Autowired 
    UpdateLivro updateLivro;

    @Autowired 
    DeleteLivro deleteLivro;

    @Autowired
    LivroProvider livroProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Livro Livro){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createLivro);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(Livro == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createLivro.execute(id, Livro);
                break;

            case "update":
                this.updateLivro.execute(id, Livro);
                break;

            case "delete":
                this.deleteLivro.execute(id, Livro);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Livro> getAllLivros(){
        return this.livroProvider.getAll();
    }

    public Livro getLivroById(int id){
        return this.livroProvider.getOneById(id);
    }
    

}
