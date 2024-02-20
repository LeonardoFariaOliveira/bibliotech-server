package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.itemEmprestimo.CreateItemEmprestimo;
import com.example.bibliotech.commands.itemEmprestimo.DeleteItemEmprestimo;
import com.example.bibliotech.commands.itemEmprestimo.UpdateItemEmprestimo;
import com.example.bibliotech.models.ItemEmprestimo;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.ItemEmprestimoProvider;

@Service
public class ItemEmprestimoService{

    @Autowired 
    CreateItemEmprestimo createItemEmprestimo;

    @Autowired 
    UpdateItemEmprestimo updateItemEmprestimo;

    @Autowired 
    DeleteItemEmprestimo deleteItemEmprestimo;

    @Autowired
    ItemEmprestimoProvider itemEmprestimoProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, ItemEmprestimo itemEmprestimo){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createItemEmprestimo);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(itemEmprestimo == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createItemEmprestimo.execute(id, itemEmprestimo);
                break;

            case "update":
                this.updateItemEmprestimo.execute(id, itemEmprestimo);
                break;

            case "delete":
                this.deleteItemEmprestimo.execute(id, itemEmprestimo);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<ItemEmprestimo> getAllItemEmprestimos(){
        return this.itemEmprestimoProvider.getAll();
    }

    public ItemEmprestimo getItemEmprestimoById(int id){
        return this.itemEmprestimoProvider.getOneById(id);
    }
    

}
