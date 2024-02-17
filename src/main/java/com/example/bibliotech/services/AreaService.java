package com.example.bibliotech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotech.commands.area.CreateArea;
import com.example.bibliotech.commands.area.DeleteArea;
import com.example.bibliotech.commands.area.UpdateArea;
import com.example.bibliotech.models.Area;
import com.example.bibliotech.observables.ErrorObservable;
import com.example.bibliotech.providers.AreaProvider;

@Service
public class AreaService{

    @Autowired 
    CreateArea createArea;

    @Autowired 
    UpdateArea updateArea;

    @Autowired 
    DeleteArea deleteArea;

    @Autowired
    AreaProvider areaProvider;

    @SuppressWarnings("deprecation")
    public void executeVoidFunctions(String action, int id, Area area){

        var errorObservable = new ErrorObservable();

        errorObservable.addObserver(this.createArea);

        if(id == -1){
            errorObservable.setHasError(true);
        }

        if(area == null){
            errorObservable.setHasError(true);
        }

        switch (action) {
            case "create":
                this.createArea.execute(id, area);
                break;

            case "update":
                this.updateArea.execute(id, area);
                break;

            case "delete":
                this.deleteArea.execute(id, area);
                break;
        
            default:
                errorObservable.setHasError(true);
                break;
        }
    }

    public List<Area> getAllAreas(){
        return this.areaProvider.getAll();
    }

    public Area getAreaById(int id){
        return this.areaProvider.getOneById(id);
    }
    

}
