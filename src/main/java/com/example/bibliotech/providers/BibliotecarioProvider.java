package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Bibliotecario;
import com.example.bibliotech.repositories.BibliotecarioRepository;

@Service
public class BibliotecarioProvider implements IGenericDao<Bibliotecario>{

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;


    @Override
    public void create(Bibliotecario object) {
    

        this.bibliotecarioRepository.save(object);

    }

    @Override
    public List<Bibliotecario> getAll() {
        return this.bibliotecarioRepository.findAll();
    }

    @Override
    public Bibliotecario getOneById(int id) {
        
        var bibliotecario = this.bibliotecarioRepository.findById(id);
        if(bibliotecario.isEmpty()){
            throw new Error("Bibliotecario não existe");
        }

        return bibliotecario.get();
        
    }

    public Bibliotecario getOneByEmail(String email) {
        
        var bibliotecario = this.bibliotecarioRepository.findByEmail(email);
        if(bibliotecario.isEmpty()){
            throw new Error("Bibliotecario não existe");
        }
        return bibliotecario.get();
        
    }

    @Override
    public void update(int id, Bibliotecario object) {
       
      
        var bibliotecario = this.bibliotecarioRepository.findById(id);
        if(bibliotecario.isEmpty()){
            throw new Error("Bibliotecario não existe");
        }
      
        bibliotecario.get().setNome(object.getNome());
        bibliotecario.get().setEmail(object.getEmail());
        bibliotecario.get().setSenha(object.getSenha());
        this.bibliotecarioRepository.save(bibliotecario.get());
        
    }

    @Override
    public void delete(int id) {

        var bibliotecario = this.bibliotecarioRepository.findById(id);
        if(bibliotecario.isEmpty()){
            throw new Error("Bibliotecario não existe");
        }
        
        this.bibliotecarioRepository.deleteById(id);
        
    }

    
}
