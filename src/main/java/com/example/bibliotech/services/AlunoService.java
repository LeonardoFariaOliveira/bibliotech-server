package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.aluno.CreateAluno;
import com.example.bibliotech.commands.aluno.DeleteAluno;
import com.example.bibliotech.commands.aluno.UpdateAluno;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AlunoProvider;

@Service
public class AlunoService{

    @Autowired 
    CreateAluno createAluno;

    @Autowired 
    UpdateAluno updateAluno;

    @Autowired 
    DeleteAluno deleteAluno;

    @Autowired
    AlunoProvider alunoProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Aluno aluno){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createAluno);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(aluno == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createAluno.execute(id, aluno);
                break;

            case "update":
                this.updateAluno.execute(id, aluno);
                break;

            case "delete":
                this.deleteAluno.execute(id, aluno);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Aluno> getAllAlunos(){
        return this.alunoProvider.getAll();
    }

    public Aluno getAlunoById(int id){
        return this.alunoProvider.getOneById(id);
    }
    

}
