package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Devolucao;
import com.example.bibliotech.repositories.DevolucaoRepository;

@Service
public class DevolucaoProvider implements IGenericDao<Devolucao>{

    @Autowired
    DevolucaoRepository devolucaoRepository;


    @Override
    public void create(Devolucao object) {
    

        this.devolucaoRepository.save(object);

    }

    @Override
    public List<Devolucao> getAll() {
        return this.devolucaoRepository.findAll();
    }

    @Override
    public Devolucao getOneById(int id) {
        
        var devolucao = this.devolucaoRepository.findById(id);
        if(devolucao.isEmpty()){
            throw new Error("Devolucao não existe");
        }
        return devolucao.get();
        
    }

    @Override
    public void update(int id, Devolucao object) {
       
      
        var devolucao = this.devolucaoRepository.findById(id);
        if(devolucao.isEmpty()){
            throw new Error("Devolucao não existe");
        }
      
        devolucao.get().setDataDevolucao(object.getDataDevolucao());
        devolucao.get().setMulta(object.getMulta());
        devolucao.get().setValorTotal(object.getValorTotal());
        devolucao.get().setAtraso(object.getAtraso());
        this.devolucaoRepository.save(devolucao.get());
        
    }

    @Override
    public void delete(int id) {

        var devolucao = this.devolucaoRepository.findById(id);
        if(devolucao.isEmpty()){
            throw new Error("Devolucao não existe");
        }
        
        this.devolucaoRepository.deleteById(id);
        
    }

    
}
