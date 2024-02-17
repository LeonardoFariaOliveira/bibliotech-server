package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.repositories.AlunoRepository;

@Service
public class AlunoProvider implements IGenericDao<Aluno>{

    @Autowired
    AlunoRepository alunoRepository;


    @Override
    public void create(Aluno object) {
    

        this.alunoRepository.save(object);

    }

    @Override
    public List<Aluno> getAll() {
        return this.alunoRepository.findAll();
    }

    @Override
    public Aluno getOneById(int id) {
        
        var aluno = this.alunoRepository.findById(id);
        if(aluno.isEmpty()){
            throw new Error("Aluno não existe");
        }
        return aluno.get();
        
    }

    @Override
    public void update(int id, Aluno object) {
       
      
        var aluno = this.alunoRepository.findById(id);
        if(aluno.isEmpty()){
            throw new Error("Aluno não existe");
        }
      
        aluno.get().setCpf(object.getCpf());
        aluno.get().setNome(object.getNome());
        aluno.get().setEndereco(object.getEndereco());
        this.alunoRepository.save(aluno.get());
        
    }

    @Override
    public void delete(int id) {

        var aluno = this.alunoRepository.findById(id);
        if(aluno.isEmpty()){
            throw new Error("Aluno não existe");
        }
        
        this.alunoRepository.deleteById(id);
        
    }

    
}
