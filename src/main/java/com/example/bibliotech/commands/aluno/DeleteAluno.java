package com.example.bibliotech.commands.aluno;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bibliotech.interfaces.ICommand;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AlunoProvider;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class DeleteAluno implements ICommand, Observer{

    @Autowired
    AlunoProvider alunoProvider;

    @Override
    public void execute(int id, Object object) {
       this.alunoProvider.delete(id);
    }

    @Override
    public void update(Observable o, Object arg) {
       
        var hasError = ((ErrorObservable) o).hasError();
        if(hasError)
        throw new Error("Houve um erro, tente novamente");
    }
    
}
