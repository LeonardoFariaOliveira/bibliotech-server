package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.ItemEmprestimo;
import com.example.bibliotech.repositories.ItemEmprestimoRepository;

@Service
public class ItemEmprestimoProvider implements IGenericDao<ItemEmprestimo>{

    @Autowired
    ItemEmprestimoRepository itemEmprestimoRepository;


    @Override
    public void create(ItemEmprestimo object) {
    

        this.itemEmprestimoRepository.save(object);

    }

    @Override
    public List<ItemEmprestimo> getAll() {
        return this.itemEmprestimoRepository.findAll();
    }

    @Override
    public ItemEmprestimo getOneById(int id) {
        
        var itemEmprestimo = this.itemEmprestimoRepository.findById(id);
        if(itemEmprestimo.isEmpty()){
            throw new Error("ItemEmprestimo não existe");
        }
        return itemEmprestimo.get();
        
    }

    @Override
    public void update(int id, ItemEmprestimo object) {
       
      
        var itemEmprestimo = this.itemEmprestimoRepository.findById(id);
        if(itemEmprestimo.isEmpty()){
            throw new Error("ItemEmprestimo não existe");
        }
      
        itemEmprestimo.get().setDataDevolucao(object.getDataDevolucao());
        this.itemEmprestimoRepository.save(itemEmprestimo.get());
        
    }

    @Override
    public void delete(int id) {

        var itemEmprestimo = this.itemEmprestimoRepository.findById(id);
        if(itemEmprestimo.isEmpty()){
            throw new Error("ItemEmprestimo não existe");
        }
        
        this.itemEmprestimoRepository.deleteById(id);
        
    }

    
}
