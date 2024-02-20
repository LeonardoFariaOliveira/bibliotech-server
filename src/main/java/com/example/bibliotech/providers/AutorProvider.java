package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Autor;
import com.example.bibliotech.repositories.AutorRepository;

@Service
public class AutorProvider implements IGenericDao<Autor>{

    @Autowired
    AutorRepository autorRepository;


    @Override
    public void create(Autor object) {
    

        this.autorRepository.save(object);

    }

    @Override
    public List<Autor> getAll() {
        return this.autorRepository.findAll();
    }

    @Override
    public Autor getOneById(int id) {
        
        var autor = this.autorRepository.findById(id);
        if(autor.isEmpty()){
            throw new Error("Autor não existe");
        }
        return autor.get();
        
    }

    @Override
    public void update(int id, Autor object) {
       
      
        var autor = this.autorRepository.findById(id);
        if(autor.isEmpty()){
            throw new Error("Autor não existe");
        }
      
        autor.get().setSobrenome(object.getSobrenome());
        autor.get().setNome(object.getNome());
        autor.get().setTitulacao(object.getTitulacao());
        this.autorRepository.save(autor.get());
        
    }

    @Override
    public void delete(int id) {

        var autor = this.autorRepository.findById(id);
        if(autor.isEmpty()){
            throw new Error("Autor não existe");
        }
        
        this.autorRepository.deleteById(id);
        
    }

    public Autor getOneByName(String nome) {
        
        var autor = this.autorRepository.findByNome(nome);
        if(autor.isEmpty()){
            return null;
        }
        return autor.get();
        
    }

    
}
