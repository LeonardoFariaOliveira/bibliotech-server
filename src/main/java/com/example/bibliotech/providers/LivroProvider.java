package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Livro;
import com.example.bibliotech.repositories.LivroRepository;

@Service
public class LivroProvider implements IGenericDao<Livro>{

    @Autowired
    LivroRepository livroRepository;


    @Override
    public void create(Livro object) {
    

        this.livroRepository.save(object);

    }

    @Override
    public List<Livro> getAll() {
        return this.livroRepository.findAll();
    }

    @Override
    public Livro getOneById(int id) {
        
        var livro = this.livroRepository.findById(id);
        if(livro.isEmpty()){
            throw new Error("Livro não existe");
        }
        return livro.get();
        
    }

    @Override
    public void update(int id, Livro object) {
       
      
        var livro = this.livroRepository.findById(id);
        if(livro.isEmpty()){
            throw new Error("Livro não existe");
        }
      
        livro.get().setDisponivel(object.isDisponivel());
        livro.get().setDataPrevista(object.getDataPrevista());
        this.livroRepository.save(livro.get());
        
    }

    @Override
    public void delete(int id) {

        var Livro = this.livroRepository.findById(id);
        if(Livro.isEmpty()){
            throw new Error("Livro não existe");
        }
        
        this.livroRepository.deleteById(id);
        
    }

    
}
