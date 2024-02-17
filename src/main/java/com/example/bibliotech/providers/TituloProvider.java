package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Titulo;
import com.example.bibliotech.repositories.TituloRepository;

@Service
public class TituloProvider implements IGenericDao<Titulo>{

    @Autowired
    TituloRepository tituloRepository;


    @Override
    public void create(Titulo object) {
    

        this.tituloRepository.save(object);

    }

    @Override
    public List<Titulo> getAll() {
        return this.tituloRepository.findAll();
    }

    @Override
    public Titulo getOneById(int id) {
        
        var titulo = this.tituloRepository.findById(id);
        if(titulo.isEmpty()){
            throw new Error("Titulo não existe");
        }
        return titulo.get();
        
    }

    @Override
    public void update(int id, Titulo object) {
       
      
        var titulo = this.tituloRepository.findById(id);
        if(titulo.isEmpty()){
            throw new Error("Titulo não existe");
        }
      
        titulo.get().setAno(object.getAno());
        titulo.get().setIsbn(object.getIsbn());
        titulo.get().setPrazo(object.getPrazo());
        titulo.get().setNome(object.getNome());
        titulo.get().setEdicao(object.getEdicao());
        this.tituloRepository.save(titulo.get());
        
    }

    @Override
    public void delete(int id) {

        var titulo = this.tituloRepository.findById(id);
        if(titulo.isEmpty()){
            throw new Error("Titulo não existe");
        }
        
        this.tituloRepository.deleteById(id);
        
    }

    
}
