package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Emprestimo;
import com.example.bibliotech.repositories.EmprestimoRepository;

@Service
public class EmprestimoProvider implements IGenericDao<Emprestimo>{

    @Autowired
    EmprestimoRepository emprestimoRepository;


    @Override
    public void create(Emprestimo object) {
    

        this.emprestimoRepository.save(object);

    }

    @Override
    public List<Emprestimo> getAll() {
        return this.emprestimoRepository.findByOrderByDataEmprestimoDesc();
    }

    public List<Emprestimo> getAllByAluno(Aluno aluno) {
        return this.emprestimoRepository.findByAluno(aluno);
    }

    @Override
    public Emprestimo getOneById(int id) {
        
        var emprestimo = this.emprestimoRepository.findById(id);
        if(emprestimo.isEmpty()){
            throw new Error("Emprestimo não existe");
        }
        return emprestimo.get();
        
    }

    @Override
    public void update(int id, Emprestimo object) {
       
      
        var emprestimo = this.emprestimoRepository.findById(id);
        if(emprestimo.isEmpty()){
            throw new Error("Emprestimo não existe");
        }
      
        emprestimo.get().setMulta(object.getMulta());
        this.emprestimoRepository.save(emprestimo.get());
        
    }

    @Override
    public void delete(int id) {

        var emprestimo = this.emprestimoRepository.findById(id);
        if(emprestimo.isEmpty()){
            throw new Error("Emprestimo não existe");
        }
        
        this.emprestimoRepository.deleteById(id);
        
    }

    
}
