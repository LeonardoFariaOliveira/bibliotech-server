package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.emprestimo.CreateEmprestimo;
import com.example.bibliotech.commands.emprestimo.DeleteEmprestimo;
import com.example.bibliotech.commands.emprestimo.UpdateEmprestimo;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Emprestimo;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.EmprestimoProvider;

@Service
public class EmprestimoService{

    @Autowired 
    CreateEmprestimo createEmprestimo;

    @Autowired 
    UpdateEmprestimo updateEmprestimo;

    @Autowired 
    DeleteEmprestimo deleteEmprestimo;

    @Autowired
    EmprestimoProvider emprestimoProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Emprestimo emprestimo){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createEmprestimo);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(emprestimo == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createEmprestimo.execute(id, emprestimo);
                break;

            case "update":
                this.updateEmprestimo.execute(id, emprestimo);
                break;

            case "delete":
                this.deleteEmprestimo.execute(id, emprestimo);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Emprestimo> getAllEmprestimos(){
        return this.emprestimoProvider.getAll();
    }

    public Emprestimo getEmprestimoById(int id){
        return this.emprestimoProvider.getOneById(id);
    }

    public List<Emprestimo> getEmprestimosByAluno(Aluno aluno){
        return this.emprestimoProvider.getAllByAluno(aluno);
    }
    

}
