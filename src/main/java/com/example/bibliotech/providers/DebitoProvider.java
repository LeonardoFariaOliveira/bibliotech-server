package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Debito;
import com.example.bibliotech.repositories.DebitoRepository;

@Service
public class DebitoProvider implements IGenericDao<Debito>{

    @Autowired
    DebitoRepository debitoRepository;


    @Override
    public void create(Debito object) {
    

        this.debitoRepository.save(object);

    }

    @Override
    public List<Debito> getAll() {
        return this.debitoRepository.findAll();
    }

    @Override
    public Debito getOneById(int id) {
        
        var debito = this.debitoRepository.findById(id);
        if(debito.isEmpty()){
            throw new Error("Debito não existe");
        }
        return debito.get();
        
    }

    @Override
    public void update(int id, Debito object) {
       
      
        var debito = this.debitoRepository.findById(id);
        if(debito.isEmpty()){
            throw new Error("Debito não existe");
        }
      
        debito.get().setValor(object.getValor());
        this.debitoRepository.save(debito.get());
        
    }

    @Override
    public void delete(int id) {

        var debito = this.debitoRepository.findById(id);
        if(debito.isEmpty()){
            throw new Error("Debito não existe");
        }
        
        this.debitoRepository.deleteById(id);
        
    }


    public Debito getOneByAluno(Aluno aluno) {
        
        var debito = this.debitoRepository.findByAluno(aluno);
        if(debito.isEmpty()){
            return null;
        }
        return debito.get();
        
    }
    
}
