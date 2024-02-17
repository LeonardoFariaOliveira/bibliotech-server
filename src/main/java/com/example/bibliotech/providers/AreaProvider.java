package com.example.bibliotech.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.interfaces.IGenericDao;
import com.example.bibliotech.models.Area;
import com.example.bibliotech.repositories.AreaRepository;

@Service
public class AreaProvider implements IGenericDao<Area>{

    @Autowired
    AreaRepository areaRepository;


    @Override
    public void create(Area object) {
    

        this.areaRepository.save(object);

    }

    @Override
    public List<Area> getAll() {
        return this.areaRepository.findAll();
    }

    @Override
    public Area getOneById(int id) {
        
        var area = this.areaRepository.findById(id);
        if(area.isEmpty()){
            throw new Error("Area não existe");
        }

        return area.get();
        
    }

    @Override
    public void update(int id, Area object) {
       
      
        var area = this.areaRepository.findById(id);
        if(area.isEmpty()){
            throw new Error("Area não existe");
        }
      
        area.get().setNome(object.getNome());
        area.get().setDescricao(object.getDescricao());
        this.areaRepository.save(area.get());
        
    }

    @Override
    public void delete(int id) {

        var area = this.areaRepository.findById(id);
        if(area.isEmpty()){
            throw new Error("Area não existe");
        }
        
        this.areaRepository.deleteById(id);
        
    }

    
}
